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

    public boolean estaJuegoIniciado()
    {
        return this.juegoIniciado;
    }


    public static Juego GetInstance()
    {

        if(instance == null)
        {
            instance = new Juego();
        }

        return instance;
    }

    public static void ResetInstance()
    {
        instance = new Juego();
    }

    public boolean esMiTurno()
    {
        return this.usuario.getId() == this.idTurnoActual;
    }

    public void setGameController(GameController gameController)
    {
        this.gameController = gameController;
    }

    public void setEsperaController(EsperaController esperaController) {
        this.esperaController = esperaController;
    }

    public ServerConnection GetConnection()
    {
        return server;
    }
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