package client.interfaztest;

import client.Juego;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController { //onSendButtonClick
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        boolean result = Juego.GetInstance().Conectarse("example");
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
        Juego.GetInstance().GetConnection().Enviar_mensaje("Hola <<mensaje>>");

    }
}