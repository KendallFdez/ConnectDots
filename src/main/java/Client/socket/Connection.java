package Client.socket;

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
            misocket = new Socket("127.0.0.1", 9999);
            ServerConnection cliente = new ServerConnection(misocket);
            Connection.server = cliente;
            new Thread(cliente).start();
            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}