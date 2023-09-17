package server;

import server.socket.Recepcion;
import server.socket.Repartidor;
public class ServerRunner {
    public static void main(String[] args) {
        Repartidor repartidor = new Repartidor();
        Recepcion recepcion=new Recepcion(repartidor);

        Thread mihilo2= new Thread(repartidor);

        mihilo2.start();
        Thread mihilo= new Thread(recepcion);

        mihilo.start();
    }
}
