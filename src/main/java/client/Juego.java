package client;

import client.Model.Usuario;
import client.interfaz.EsperaController;
import client.interfaz.GameController;
import client.socket.ServerConnection;
import javafx.application.Platform;
import javafx.scene.control.Dialog;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Clase que representa la lógica del juego y la comunicación con el servidor.
 */
public class Juego implements Runnable{

    private static Juego instance;

    private boolean juegoIniciado;

    private ServerConnection server;

    private Usuario usuario;

    private int idTurnoActual;

    private GameController gameController;

    private boolean leyendoMensajes = true;

    private EsperaController esperaController;

    private Juego ()
    {
        this.juegoIniciado = false;
        this.idTurnoActual = -1;
    }

    /**
     * Comprueba si el juego está iniciado.
     */
    public boolean estaJuegoIniciado()
    {
        return this.juegoIniciado;
    }

    /**
     * Obtiene la instancia de la clase Juego.
     *
     * @return La instancia de la clase Juego.
     */
    public static Juego GetInstance()
    {

        if(instance == null)
        {
            instance = new Juego();
        }

        return instance;
    }
    /**
     * Restablece la instancia de la clase Juego.
     */
    public static void ResetInstance()
    {
        instance = new Juego();
    }
    /**
     * Comprueba si es el turno del usuario actual.
     *
     * @return boolean si es el turno del usuario.
     */
    public boolean esMiTurno()
    {
        return this.usuario.getId() == this.idTurnoActual;
    }

    /**
     * Establece el controlador del juego.
     *
     * @param gameController El controlador del juego.
     * @return boolean si se estableció el controlador con éxito
     */
    public void setGameController(GameController gameController)
    {
        this.gameController = gameController;
    }

    /**
     * Establece el controlador de espera.
     *
     * @param esperaController El controlador de espera.
     * @return boolean si se estableció el controlador con éxito
     */
    public void setEsperaController(EsperaController esperaController) {
        this.esperaController = esperaController;
    }

    /**
     * Obtiene la conexión al servidor.
     *
     * @return La conexión al servidor.
     */
    public ServerConnection GetConnection()
    {
        return server;
    }

    /**
     * Realiza la conexión al servidor.
     *
     * @param name El nombre del usuario.
     * @return boolean si la conexión fue exitosa.
     */
    public boolean Conectarse(String name)
    {
        Socket misocket = null;
        try {
            misocket = new Socket("127.0.0.1", 9999);
            ServerConnection cliente = new ServerConnection(misocket);
            cliente.Enviar_mensaje(Comandos.GetComandoConexion(name));
            System.out.println(Comandos.GetComandoConexion(name));
            String entrada = cliente.LeerEntrada();
            System.out.println(entrada);
            JSONObject receivedJson = new JSONObject(entrada);
            int id = receivedJson.getInt("id");
            usuario = new Usuario(name, id);
            System.out.println("conectado");

            server = cliente;
            new Thread(cliente).start();
            new Thread(this).start();
            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene el usuario actual.
     *
     * @return El usuario actual.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void run() {
        JSONObject receivedJson = null;
        try {
            while (leyendoMensajes) {
                TimeUnit.MILLISECONDS.sleep(500);
                if(this.GetConnection().Revisar_bandeja())
                {
                    String mensaje = this.GetConnection().Obtener_mensaje();
                    receivedJson = new JSONObject(mensaje);
                }
                if(receivedJson != null)
                {
                    this.revisarComandosPrevioJuego(receivedJson);
                }
                receivedJson = null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Analiza los comandos recibidos del servidor antes del inicio del juego y toma acciones en consecuencia.
     *
     * @param jsonObject El objeto JSON que contiene el comando recibido del servidor.
     */
    private void revisarComandosPrevioJuego(JSONObject jsonObject)
    {
        switch (jsonObject.getString("comando")) {
            case "serverIniciado":
                this.serverIniciado(jsonObject);
                break;
            case "actualizarInformacion":
                this.actualizarInformacion(jsonObject);
                break;
            default:
                System.err.println("Comando no encontrado");

        }

    }

    /**
     * Finaliza el juego y muestra un diálogo de ganador.
     *
     * @param ganador El nombre del jugador ganador.
     */
    private void finalizarJuego(String ganador)
    {
        Platform.runLater(() -> {
            Dialog<String> dialog = this.gameController.CreateDialog(ganador);
            Optional<String> result = dialog.showAndWait();
            this.esperaController.resetWindow();
        });


        this.leyendoMensajes = false;
        this.GetConnection().finalizarConexion();

    }

    /**
     * Maneja el comando "serverIniciado" del servidor.
     *
     * @param jsonObject El objeto JSON que contiene los datos del servidor.
     */
    private void serverIniciado(JSONObject jsonObject)
    {
        //"{\"comando\":\"serverIniciado\",\"idTurnoActual\":\"%d\",\"nombreUsuario\":\"%s\"}"
        String nombre = jsonObject.getString("nombreUsuario");
        this.idTurnoActual = jsonObject.getInt("idTurnoActual");
        Platform.runLater(() -> {
            this.esperaController.CambiarPantalla(nombre, this.gameController);
        });

        this.juegoIniciado = true;
    }

    /**
     * Actualiza la información del juego en función de los comandos recibidos del servidor.
     *
     * @param jsonObject El objeto JSON que contiene la información del juego.
     */
    private void actualizarInformacion(JSONObject jsonObject)
    {

        int numeroLinea = jsonObject.getInt("numeroLinea");
        String tipo = jsonObject.getString("tipo");
        String nombreActual = jsonObject.getString("nombreActual");
        String estado = jsonObject.getString("estado");
        String sigJugador = jsonObject.getString("nombreSigJugador");
        int sigJugadorId = jsonObject.getInt("idSigJugador");
        JSONArray cuadros = jsonObject.getJSONArray("cuadros");
        this.idTurnoActual = sigJugadorId;

        Platform.runLater(() -> {
            System.out.println("Actualizando informacion");
            this.gameController.ponerLinea(numeroLinea, tipo);
            this.gameController.cambiarNombre(sigJugador);

            Iterator<Object> iteratorObj = cuadros.iterator();
            while (iteratorObj.hasNext()) {
                Object next = iteratorObj.next();
                try {

                    int cuadro = Integer.parseInt(next.toString());
                    this.gameController.ponerNombreCuadro(cuadro, nombreActual);

                } catch (NumberFormatException e) {
                    System.out.println(next);
                }

            }
        });

        if(estado.equals("finalizado"))
        {
            this.finalizarJuego(sigJugador);
            Juego.ResetInstance();
        }
    }
}