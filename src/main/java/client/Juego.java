package client;

import client.Model.Usuario;
import client.interfaz.EsperaController;
import client.interfaz.GameController;
import client.socket.ServerConnection;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Juego implements Runnable{

    private static Juego instance;

    private boolean juegoIniciado;

    private ServerConnection server;

    private Usuario usuario;

    private GameController gameController;

    private EsperaController esperaController;

    private Juego ()
    {
        this.juegoIniciado = false;
    }

    public boolean estaJuegoIniciado()
    {
        return this.juegoIniciado;
    }


    public static Juego GetInstance()
    {
        if(instance == null)
        {
            instance = new Juego();
        }

        return instance;
    }

    public void setGameController(GameController gameController)
    {
        this.gameController = gameController;
    }

    public void setEsperaController(EsperaController esperaController) {
        this.esperaController = esperaController;
    }

    public ServerConnection GetConnection()
    {
        return server;
    }
    public boolean Conectarse(String name)
    {
        Socket misocket = null;
        try {
            misocket = new Socket("127.0.0.1", 9999);
            ServerConnection cliente = new ServerConnection(misocket);
            cliente.Enviar_mensaje("{\"comando\":\"conexion\",\"nombre\":\"%s\"}".formatted(name));
            String entrada = cliente.LeerEntrada();
            JSONObject receivedJson = new JSONObject(entrada);
            int id = receivedJson.getInt("id");
            usuario = new Usuario(name, id);

            server = cliente;
            new Thread(cliente).start();
            new Thread(this).start();
            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void run() {
        JSONObject receivedJson = null;
        try {
            while (true) {
                if(this.GetConnection().Revisar_bandeja())
                {
                    receivedJson = new JSONObject(this.GetConnection().Obtener_mensaje());
                }
                if(!this.juegoIniciado && receivedJson != null)
                {
                    this.revisarComandosPrevioJuego(receivedJson);
                } else if (receivedJson != null) {
                    this.revisarComandosEnJuego(receivedJson);
                }
                receivedJson = null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void revisarComandosPrevioJuego(JSONObject jsonObject)
    {

    }

    private void revisarComandosEnJuego(JSONObject jsonObject)
    {

    }
}