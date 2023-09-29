package server.modelo;

import server.socket.ClienteConnection;

/**
 * Clase que representa un cliente conectado al servidor.
 */
public class Cliente {

    private ClienteConnection clienteConnection;
    private String nombre;
    private int id;

    /**
     * Constructor de la clase Cliente.
     *
     * @param clienteConnection La conexión del cliente.
     * @param nombre El nombre del cliente.
     * @param id El identificador del cliente.
     */
    public Cliente(ClienteConnection clienteConnection, String nombre, int id) {
        this.clienteConnection = clienteConnection;
        this.nombre = nombre;
        this.id = id;
    }
    /**
     * Obtiene la conexión del cliente.
     *
     * @return La conexión del cliente.
     */
    public ClienteConnection getConnection() {
        return clienteConnection;
    }

    /**
     * Comprueba si el cliente está conectado.
     *
     * @return boolean si el cliente está conectado.
     */
    public boolean estaConectado()
    {
        return clienteConnection.conectado;
    }
    /**
     * Inicia la escucha del cliente en un hilo separado.
     */
    public void iniciarEscucha()
    {
        Thread mihilo= new Thread(this.getConnection());
        mihilo.start();
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return El identificador del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }
}
