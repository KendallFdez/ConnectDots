package client.interfaztest;

import client.Juego;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Clase HelloController que maneja las acciones de los botones en la interfaz de usuario.
 */
public class HelloController { //onSendButtonClick
    @FXML
    private Label welcomeText;

    /**
     * Método que maneja el evento de clic del botón "Hello".
     * Intenta conectarse a un servidor con el nombre "example".
     * Si la conexión es exitosa, muestra "Conectado" en la etiqueta de bienvenida.
     * Si la conexión falla, muestra "Error de conexión" en la etiqueta de bienvenida.
     */
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
    /**
     * Método que maneja el evento de clic del botón "Send".
     * Envía un mensaje al servidor conectado.
     */
    @FXML
    protected void onSendButtonClick() {
        Juego.GetInstance().GetConnection().Enviar_mensaje("Hola <<mensaje>>");

    }
}