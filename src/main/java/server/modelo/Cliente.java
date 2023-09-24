package server.modelo;

import server.socket.ClienteConnection;

public class Cliente {

    private ClienteConnection clienteConnection;
    private String nombre;
    private int id;

    public Cliente(ClienteConnection clienteConnection, String nombre, int id) {
        this.clienteConnection = clienteConnection;
        this.nombre = nombre;
        this.id = id;
    }

    public ClienteConnection getConnection() {
        return clienteConnection;
    }

    public boolean estaConectado()
    {
        return clienteConnection.conectado;
    }

    public void iniciarEscucha()
    {
        Thread mihilo= new Thread(this.getConnection());
        mihilo.start();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
