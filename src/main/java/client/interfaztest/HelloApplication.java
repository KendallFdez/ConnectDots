package client.interfaztest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase HelloApplication que extiende la clase Application de JavaFX.
 * Esta clase maneja la inicialización de la interfaz de usuario de la aplicación.
 */
public class HelloApplication extends Application {
    /**
     * Método que se llama cuando se inicia la aplicación.
     * Carga la vista FXML y establece la escena y el título de la ventana de la aplicación.
     *
     * @param stage La escena de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 624, 750);
        stage.setTitle("Connect Dots");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal que inicia la aplicación.
     */
    public static void main(String[] args) {
        launch();
    }
}