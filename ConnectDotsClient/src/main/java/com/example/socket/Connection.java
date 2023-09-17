package com.example.socket;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    private static ServerConnection server;

    public static ServerConnection GetConnection()
    {
        return Connection.server;
    }
    public static boolean Start()
    {
        Socket misocket = null;
        try {
<<<<<<< Updated upstream:ConnectDotsClient/src/main/java/com/example/socket/Connection.java
            misocket = new Socket("192.168.100.251", 9999);
            ClienteConnection cliente = new ClienteConnection(misocket);
            cliente.Enviar_mensaje("hola connecion realizada");
=======
            misocket = new Socket("127.0.0.1", 9999);
            ServerConnection cliente = new ServerConnection(misocket);
>>>>>>> Stashed changes:src/main/java/Client/socket/Connection.java
            Connection.server = cliente;
            new Thread(cliente).start();
            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
