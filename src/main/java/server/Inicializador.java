package server;

import server.modelo.Cliente;
import server.socket.ClienteConnection;
import server.socket.Recepcion;
import java.time.Duration;
import java.time.Instant;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Inicializador{

    private Recepcion recepcion;

    private Juego juego;

    public Inicializador(Recepcion recepcion, Juego juego) {
        this.recepcion = recepcion;
        this.juego = juego;
    }

    private void Inicializar()
    {
        while(recepcion.clienteCola.getSize()>0)
        {
            juego.agregarCliente(recepcion.clienteCola.dequeue().getData());
        }

        juego.iniciar();
    }

    public void ejecutar() {
        System.out.println("Ejecutando");
        long start = 0;
        long end ;
        boolean inicializando = false;
        long segundosEspera = 5;
        int cantidadJugadores = 2;

        try {
            while(true){
                TimeUnit.MILLISECONDS.sleep(500);
                if(juego.estaIniciado()){
                    continue;
                }
                else if(juego.estaFinalizado())
                {
                    juego = new Juego();
                    new Thread(juego).start();
                }

                if(this.recepcion.clienteCola.getSize() >= cantidadJugadores && !inicializando)
                {
                    System.out.println("Juego iniciando en: "+ segundosEspera);
                    start = System.currentTimeMillis();
                    inicializando = true;
                }
                if(inicializando)
                {

                    end = System.currentTimeMillis();
                    System.out.println("Juego iniciando en: "+ (segundosEspera - (end - start)/1000));
                    if(end - start > segundosEspera * 1000)
                    {
                        this.Inicializar();
                        inicializando = false;
                    }
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }





}
