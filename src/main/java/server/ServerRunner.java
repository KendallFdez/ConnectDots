package server;

import server.socket.Recepcion;
public class ServerRunner {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Recepcion recepcion=new Recepcion();
        Inicializador inicializador = new Inicializador(recepcion, juego);

        new Thread(juego).start();
        new Thread(recepcion).start();
        inicializador.ejecutar();
    }
}
