package server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Clase de servidor que se encarga de recibir los mensajes y reenviarlos
 */
public class Recepcion implements Runnable {
    /**
     * Representa una instancia de la clase encargada de recibir los mensajes
     */
    public Repartidor repartidor;

    /**
     * Crea una instancia de servidor usando una recepcion
     * @param repartidor
     */
    public Recepcion(Repartidor repartidor){

        this.repartidor = repartidor;

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
//guardar variable mi usuario en recepcion,
                Socket misocket = servidor.accept();

                ClienteConnection miusuario=new ClienteConnection("nick", "ip", misocket);

                //repartidor.AgregarConexion(miusuario);
                //String mensajeMetadata = miusuario.LeerEntrada();
                //System.out.println(mensajeMetadata);

                Thread mihilo= new Thread(miusuario);

                mihilo.start();


            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}