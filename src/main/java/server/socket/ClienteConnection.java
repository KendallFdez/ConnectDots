package server.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Clase encargada de crear conexiones entre clientes y el servidor
 */
public class ClienteConnection implements Runnable {
    /**
     * Representa la informacion de la ventana(nombre de usuario e ip)
     */
    String nick, ip;
    /**
     * Representa el texto a enviar
     */
    public String mensaje;

    public boolean conectado;
    /**
     * Representa una linea de salida de datos
     */
    private DataOutputStream envioDatos;
    /**
     * Representa una linea de entrada de datos
     */
    private DataInputStream entradaDatos;
    /**
     * Representa el socket del cliente
     */
    Socket socket;
    /**
     * Representa los mensajes recibidos
     */
    public ConcurrentLinkedQueue<String> mensajes_recibidos;

    /**
     * Crea un paquete con la informacion de cada mensaje
     * @param nick Quien lo envia
     * @param ip Ip de quien lo envia
     * @param socket socket al que pertenece
     */
    public ClienteConnection(String nick, String ip, Socket socket){

        this.nick = nick;

        this.ip = ip;

        this.socket = socket;

        this.mensajes_recibidos= new ConcurrentLinkedQueue<>();

        this.conectado = true;

    }

    /**
     * Recibe los datos de la linea de entrada de datos
     */
    public DataInputStream getEntradaDatos() {
        if (this.entradaDatos == null) {
            try {
                this.entradaDatos = new DataInputStream(this.socket.getInputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return entradaDatos;
    }

    /**
     * Envia los datos de la linea de salida de datos
     */
    public DataOutputStream getEnvioDatos() {
        if (this.envioDatos == null) {
            try {
                this.envioDatos = new DataOutputStream(this.socket.getOutputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return envioDatos;
    }

    /**
     * Conecta al cliente con el socket dado
     * @param misocket Usado para concetar al cliente
     */
    public ClienteConnection(Socket misocket) {
        this.socket= misocket;
    }

    /**
     * Crea una linea de envio y escribe un mensaje con los datos
     * @param mensaje La clase para la informacion de los mensajes
     */
    /**
     * Crea una linea de envio y escribe un mensaje con los datos
     *
     * @param mensaje La clase para la informacion de los mensajes
     */
    public void Enviar_mensaje(String mensaje) {
        try {
            this.getEnvioDatos().writeUTF(mensaje);
            this.getEnvioDatos().flush();

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println(e1.getMessage());
        }

    }


    /**
     * Devuelve el primer elemento de la lista de mensajes
     * @return El primer elemento de la lista de mensajes
     */
    public String Obtener_mensaje(){

        return this.mensajes_recibidos.poll();
    }


    /**
     * Función para revisar el cliente recibe mensajes
     * @return Un booleano que dice si la lista de mensajes recibidos tiene algun elemento
     */
    public Boolean Revisar_bandeja(){
        return this.mensajes_recibidos != null && !this.mensajes_recibidos.isEmpty();


    }

    /**
     * @param nick El nuevo nombre de usuario
     */
    public void setNick(String nick){
        this.nick= nick;
    }
    /**
     * @return Devuelve el nombre de usuario
     */
    public String getNick() {
        return nick;
    }

    public String LeerEntrada() {
        DataInputStream entradaDatos = this.getEntradaDatos();
        try {
            return entradaDatos.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void EnviarJSON(String jsonString) {
        try {
            // Indicar que se está enviando JSON
            this.getEnvioDatos().writeUTF("JSON");
            // Enviar la cadena JSON
            this.getEnvioDatos().writeUTF(jsonString);
            this.getEnvioDatos().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String RecibirJSON() {
        try {
            String tipoMensaje = this.getEntradaDatos().readUTF();
            if (tipoMensaje.equals("JSON")) {
                String jsonString = this.getEntradaDatos().readUTF();
                return jsonString;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        System.out.println("Se inicio el run");

        try {
            while(true){
                String message = this.LeerEntrada();

                if(this.mensajes_recibidos==null){
                    this.mensajes_recibidos= new ConcurrentLinkedQueue<>();
                }
                System.out.println(message);

                this.mensajes_recibidos.offer(message);
            }

        } catch (Exception e) {
            this.conectado = false;
            System.out.println("Salio");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}