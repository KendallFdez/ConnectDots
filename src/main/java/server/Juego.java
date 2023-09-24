package server;

import server.modelo.Cliente;
import server.socket.ClienteConnection;
import utils.Cola.Cola;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Juego  implements Runnable{

    ConcurrentHashMap<Integer, Cliente> conexiones;

    public JuegoEstado estado;

    public Juego(){
        this.conexiones = new ConcurrentHashMap<>();
        this.estado = JuegoEstado.enEspera;
    }

    public void reiniciar()
    {
        this.conexiones.clear();
        this.estado = JuegoEstado.enEspera;
    }

    public void iniciar()
    {
        this.estado = JuegoEstado.iniciado;
    }

    public boolean estaIniciado()
    {
        return this.estado == JuegoEstado.iniciado;
    }

    public boolean agregarCliente(Cliente cliente)
    {
        if(this.estado.equals(JuegoEstado.enEspera))
        {
            cliente.iniciarEscucha();
            conexiones.put(cliente.getId(), cliente);
            return true;
        }

        return false;
    }


    public void EnviarMensajeATodos(String jsonString) {
        Enumeration<Integer> llaves = this.conexiones.keys();
        while (llaves.hasMoreElements()) {
            int llave = llaves.nextElement();
            if (this.conexiones.containsKey(llave)) {
                this.conexiones.get(llave).getConnection().EnviarJSON(jsonString);
            }
        }
    }




    /**
     * Revisa la bandeja de cada conexion para ver si tienen mensajes pendientes y los envia
     */
    @Override
    public void run() {
        while (true) {
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
                    System.out.println(mensaje);

                    // Verificar si el mensaje es un JSON
                    if (mensaje.startsWith("JSON")) {
                        String jsonString = cliente.getConnection().RecibirJSON();
                        if (jsonString != null) {
                            // Procesar el JSON recibido
                            System.out.println("JSON recibido: " + jsonString);
                        }
                    }
                }
            }
        }
    }
}
