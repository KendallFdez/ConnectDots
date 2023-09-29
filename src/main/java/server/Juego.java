package server;

import org.json.JSONObject;
import server.modelo.Cliente;
import server.modelo.MatrizJuego;
import server.socket.ClienteConnection;
import utils.Cola.Cola;
import utils.Doble.ListaDoble;
import utils.Doble.NodoDoble;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;


/**
 * Clase que representa el juego y se encarga de gestionar las conexiones de los clientes, el estado del juego y la lógica del juego.
 */
public class Juego  implements Runnable{

    ConcurrentHashMap<Integer, Cliente> conexiones;

    ListaDoble<Cliente> listaCliente;

    MatrizJuego matrizJuego;

    NodoDoble<Cliente> clienteTurnoActual;

    public JuegoEstado estado;

    private boolean ejecutandoJuego = true;

    /**
     * Constructor de la clase Juego.
     * Inicializa el juego con una matriz vacía y un estado en espera.
     */
    public Juego(){
        this.conexiones = new ConcurrentHashMap<>();
        this.listaCliente = new ListaDoble<>();
        this.estado = JuegoEstado.enEspera;
        this.matrizJuego = new MatrizJuego();
    }
    /**
     * Inicia el juego y establece el turno del primer cliente.
     */
    public void iniciar()
    {
        this.estado = JuegoEstado.iniciado;
        this.listaCliente.getTail().setNext(this.listaCliente.getHead());
        this.clienteTurnoActual = this.listaCliente.getHead();
        this.enviarMensajeATodos(Comandos.GetComandoServerIniciado(clienteTurnoActual.getData().getId(), clienteTurnoActual.getData().getNombre()));
    }

    /**
     * Verifica si el juego está en curso.
     *
     * @return Verdadero si el juego está en curso, falso en caso contrario.
     */
    public boolean estaIniciado()
    {
        return this.estado == JuegoEstado.iniciado;
    }

    /**
     * Verifica si el juego ha finalizado.
     *
     * @return Verdadero si el juego ha finalizado, falso en caso contrario.
     */
    public boolean estaFinalizado()
    {
        return this.estado == JuegoEstado.finalizado;
    }

    /**
     * Agrega un cliente al juego si el juego está en espera.
     *
     * @param cliente El cliente a agregar al juego.
     * @return Verdadero si el cliente fue agregado al juego, falso en caso contrario.
     */
    public boolean agregarCliente(Cliente cliente)
    {
        if(this.estado.equals(JuegoEstado.enEspera))
        {
            cliente.iniciarEscucha();
            conexiones.put(cliente.getId(), cliente);
            this.listaCliente.insertLast(cliente);
            return true;
        }

        return false;
    }

    /**
     * Envía un mensaje a todos los clientes conectados al juego.
     *
     * @param jsonString El mensaje a enviar en formato JSON.
     */
    public void enviarMensajeATodos(String jsonString) {
        Enumeration<Integer> llaves = this.conexiones.keys();
        while (llaves.hasMoreElements()) {
            int llave = llaves.nextElement();
            if (this.conexiones.containsKey(llave)) {
                this.conexiones.get(llave).getConnection().Enviar_mensaje(jsonString);
            }
        }
    }

    /**
     * Ejecuta el hilo que se encarga de gestionar las conexiones de los clientes y la lógica del juego.
     */
    @Override
    public void run() {
        while (ejecutandoJuego) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(this.estado != JuegoEstado.iniciado)
            {
                continue;
            }

            Enumeration<Integer> llaves = this.conexiones.keys();
            while (llaves.hasMoreElements()) {
                Integer llave = llaves.nextElement();
                Cliente cliente = this.conexiones.get(llave);
                if (cliente.getConnection().Revisar_bandeja()) {
                    String mensaje = cliente.getConnection().Obtener_mensaje();
                    JSONObject jsonObject = new JSONObject(mensaje);
                    System.out.println(mensaje);
                    this.revisarComandos(jsonObject, cliente);
                }
            }
        }
        System.out.println("juego finalizado");
    }
    private void revisarComandos(JSONObject jsonObject, Cliente cliente)
    {
        System.out.println(jsonObject.toString());
        switch (jsonObject.getString("comando")) {
            case "ponerLinea":
                this.ponerLinea(jsonObject, cliente);
                break;
            default:
                System.err.println("Comando no encontrado");

        }
    }

    private void ponerLinea(JSONObject jsonObject, Cliente cliente)
    {
        if(jsonObject.getString("tipo").equals("horizontal"))
        {
            this.matrizJuego.PonerLineaHorizontal(cliente.getId(), jsonObject.getInt("numeroLinea"));
        }
        else
        {
            this.matrizJuego.PonerLineaVertical(cliente.getId(), jsonObject.getInt("numeroLinea"));
        }

        ListaDoble<Integer> cuadros = this.matrizJuego.ValidarCuadros(cliente.getId());
        int jugadorGanador = this.matrizJuego.ObtenerUsuarioGanador();
        if(cuadros.getLength() == 0)
        {
            this.clienteTurnoActual = this.clienteTurnoActual.getNext();
        }

        Cliente jugadorNombre = this.clienteTurnoActual.getData();
        if(jugadorGanador > -1)
        {
            jugadorNombre = this.conexiones.get(jugadorGanador);
        }
        int usuarioId = jugadorGanador != -2? jugadorNombre.getId() : jugadorGanador;
        String nombre = jugadorGanador != -2? jugadorNombre.getNombre() : "Empate";
        String estado = jugadorGanador == -1? "cambioTurno" : "finalizado";
        String comando = Comandos.GetComandoActualizarCuadros(jsonObject.getInt("numeroLinea"),
                jsonObject.getString("tipo"),
                cliente,
                cuadros,
                usuarioId,
                nombre,
                estado
        );
        this.enviarMensajeATodos(comando);
        if(estado.equals("finalizado"))
        {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.ejecutandoJuego = false;
            this.estado = JuegoEstado.finalizado;

        }
    }
}
