package com.example.connectdotsclient;

<<<<<<< Updated upstream:ConnectDotsClient/src/main/java/com/example/connectdotsclient/HelloApplication.java
import com.example.socket.ClienteConnection;
=======
>>>>>>> Stashed changes:src/main/java/Client/interfaz/HelloApplication.java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

<<<<<<< Updated upstream:ConnectDotsClient/src/main/java/com/example/connectdotsclient/HelloApplication.java

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Applicacion");
=======
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 624, 750);
        stage.setTitle("Connect Dots");
>>>>>>> Stashed changes:src/main/java/Client/interfaz/HelloApplication.java
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}