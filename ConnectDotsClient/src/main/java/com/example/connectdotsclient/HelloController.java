package com.example.connectdotsclient;

import com.example.socket.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
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
}