package client.interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Inicio_Juego extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Crear un contenedor Pane
        Pane root = new Pane();

        // Crear botones
        Button botonHola = new Button("ACERCA DE ");
        Button botonSaludo = new Button("JUGAR");
        Button botonDespedida = new Button("INSTRUCCIONES ");

        // Establecer coordenadas de los botones
        botonHola.setLayoutX(100);
        botonHola.setLayoutY(300);

        botonSaludo.setLayoutX(300);
        botonSaludo.setLayoutY(300);

        botonDespedida.setLayoutX(500);
        botonDespedida.setLayoutY(300);

        // Establecer estilos y efectos para los botones
        estiloBoton(botonHola);
        estiloBoton(botonSaludo);
        estiloBoton(botonDespedida);

        // Configurar eventos de los botones
        botonHola.setOnAction(event -> {
            System.out.println("¡Hola, mundo!");
        });

        botonSaludo.setOnAction(event -> {
            System.out.println("¡Saludos!");
        });

        botonDespedida.setOnAction(event -> {
            System.out.println("¡Hasta luego!");
        });

        // Agregar los botones al contenedor
        root.getChildren().addAll(botonHola, botonSaludo, botonDespedida);

        // Crear la escena con el contenedor
        Scene scene = new Scene(root, 800, 600);

        // Establecer el título de la ventana
        primaryStage.setTitle("Connect Dots");

        // Establecer la escena en el escenario principal
        primaryStage.setScene(scene);

        // Mostrar el escenario
        primaryStage.show();
    }

    private void estiloBoton(Button boton) {
        boton.setStyle("-fx-background-color: linear-gradient(#3498db, #2980b9); -fx-text-fill: white; -fx-font-size: 18px; -fx-pref-width: 120px; -fx-pref-height: 40px; -fx-border-radius: 5px;");
        DropShadow sombra = new DropShadow();
        sombra.setColor(Color.DARKGRAY);
        sombra.setRadius(5);
        sombra.setOffsetX(2);
        sombra.setOffsetY(2);
        boton.setEffect(sombra);
    }
}
