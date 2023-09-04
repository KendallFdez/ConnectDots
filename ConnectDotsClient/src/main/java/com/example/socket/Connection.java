package com.example.socket;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    private static ClienteConnection server;
    public static boolean Start()
    {
        Socket misocket = null;
        try {
            misocket = new Socket("192.168.100.251", 9999);
            ClienteConnection cliente = new ClienteConnection(misocket);
            cliente.Enviar_mensaje("hola connecion realizada");
            Connection.server = cliente;
            new Thread(cliente).start();
            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
