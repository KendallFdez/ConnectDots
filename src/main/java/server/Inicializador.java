package server;

import server.modelo.Cliente;
import server.socket.ClienteConnection;
import server.socket.Recepcion;
import java.time.Duration;
import java.time.Instant;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        long start = 0;
        long end ;
        boolean inicializando = false;
        long segundosEspera = 1;

        try {
            while(true){
                if(juego.estaIniciado()){
                    continue;
                }

                if(this.recepcion.clienteCola.getSize() >= 2 && !inicializando)
                {
                    start = System.currentTimeMillis();
                    inicializando = true;
                }
                if(inicializando)
                {
                    end = System.currentTimeMillis();
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
