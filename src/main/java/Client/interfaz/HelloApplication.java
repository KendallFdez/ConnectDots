package Client.interfaz;

import Client.socket.ClienteConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 624, 750);
        stage.setTitle("Applicacion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}