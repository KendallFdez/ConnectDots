<<<<<<< Updated upstream:ConnectDotsServer/src/Server/Recepcion.java
package Server;

import org.json.*;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
=======
package Server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
>>>>>>> Stashed changes:src/main/java/Server/socket/Recepcion.java


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
<<<<<<< Updated upstream:ConnectDotsServer/src/Server/Recepcion.java
     * Añade una conexion el hashmap
     * @param conexion La clase especificada para conectar cada cliente
     */
    public void AgregarConexion(ClienteConnection conexion){
        this.conexiones.put(conexion.getNick(), conexion);

    }








      




    /**
     * @return El nick de cada chat
     */
    public String ObtenerNombreClientes(){
        String result = "";
        Enumeration<String> llaves = this.conexiones.keys();
        while(llaves.hasMoreElements()){
            String llave = llaves.nextElement();
            if(this.conexiones.containsKey(llave)){
                result += this.conexiones.get(llave).getNick()+";";
            }
        }
        return result;

    }

    /**
     * Recorre el hashmap y envia el mensaje dado
     * @param mensaje La clase para los mensajes
     */
    public void EnviarStringTodos(String mensaje){
        Enumeration<String> llaves = this.conexiones.keys();
        while(llaves.hasMoreElements()){
            String llave = llaves.nextElement();
            if(this.conexiones.containsKey(llave)){
                this.conexiones.get(llave).Enviar_mensaje(mensaje);// obtiene el destinatario y envia el mensaje
            }//Falta mensaje comando que envie que alguien nuevo se conecto
        }
    }

    /**
     * Revisa la bandeja de cada conexion para ver si tienen mensajes pendientes y los envia
=======
     * Inicia el servidor y crea una conexion propia
>>>>>>> Stashed changes:src/main/java/Server/socket/Recepcion.java
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
<<<<<<< Updated upstream:ConnectDotsServer/src/Server/Recepcion.java
}
=======

}
>>>>>>> Stashed changes:src/main/java/Server/socket/Recepcion.java
