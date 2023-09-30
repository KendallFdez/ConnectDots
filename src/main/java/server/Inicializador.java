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

/**
 * Clase que se encarga de inicializar el juego y ejecutarlo.
 */
public class Inicializador{

    private Recepcion recepcion;

    private Juego juego;

    /**
     * Constructor de la clase Inicializador.
     *
     * @param recepcion La instancia de la clase Recepcion.
     * @param juego La instancia de la clase Juego.
     */
    public Inicializador(Recepcion recepcion, Juego juego) {
        this.recepcion = recepcion;
        this.juego = juego;
    }

    /**
     * Inicializa el juego agregando los clientes a la cola de clientes del juego.
     */
    private void Inicializar()
    {
        while(recepcion.clienteCola.getSize()>0)
        {
            juego.agregarCliente(recepcion.clienteCola.dequeue().getData());
        }

        juego.iniciar();
    }
    /**
     * Ejecuta el juego.
     */
    public void ejecutar() {
        System.out.println("Ejecutando");
        long start = 0;
        long end ;
        boolean inicializando = false;
        long segundosEspera = 5;
        int cantidadJugadores = 1;

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
