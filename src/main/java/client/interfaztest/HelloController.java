package client.interfaztest;

import client.socket.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController { //onSendButtonClick
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        boolean result = Connection.Start();
        if(result)
        {
            welcomeText.setText("Conectado");
        }
        else
        {
            welcomeText.setText("Error de conexion");
        }

    }
    @FXML
    protected void onSendButtonClick() {
        Connection.GetConnection().Enviar_mensaje("Hola <<mensaje>>");

    }
}