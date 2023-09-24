package server.socket;

import server.modelo.Cliente;
import utils.Cola.Cola;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Clase de servidor que se encarga de recibir los mensajes y reenviarlos
 */
public class Recepcion implements Runnable {


    public int cantidadUsuariosConectados;

    public Cola<Cliente> clienteCola;

    /**
     * Crea una instancia de servidor usando una recepcion
     */
    public Recepcion(){
    }

    /**
     * Inicia el servidor y crea una conexion propia
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            ServerSocket servidor= new ServerSocket(9999);

            System.out.println("Usando el puerto: " + servidor.getLocalPort());

            while(true){
                Socket misocket = servidor.accept();

                ClienteConnection conexcion=new ClienteConnection("nick", "ip", misocket);
                int usuarioId = this.cantidadUsuariosConectados;
                this.cantidadUsuariosConectados ++;
                String mensajeMetadata = conexcion.LeerEntrada();
                Cliente cliente = new Cliente(conexcion, mensajeMetadata, usuarioId);
                clienteCola.enqueue(cliente);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}