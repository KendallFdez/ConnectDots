package com.example.connectdotsclient;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Instrucciones  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Crear un contenedor Pane
        Pane root = new Pane();

        // Crear botones
        Button botonMapa = new Button("MAPA ");
        Button botonGanar = new Button("GANAR");
        Button botonJugador = new Button("JUGADOR ");
        Button botonVolver = new Button("VOLVER");

        // Establecer coordenadas de los botones
        botonMapa.setLayoutX(100);
        botonMapa.setLayoutY(200);

        botonGanar.setLayoutX(100);
        botonGanar.setLayoutY(350);

        botonJugador.setLayoutX(500);
        botonJugador.setLayoutY(200);

        // Establecer estilos y efectos para los botones
        estiloBoton(botonMapa);
        estiloBoton(botonGanar);
        estiloBoton(botonJugador);
        estiloBoton(botonVolver);

        // Configurar eventos de los botones
        botonMapa.setOnAction(event -> {
            System.out.println("¡Hola, mundo!");
        });

        botonGanar.setOnAction(event -> {
            System.out.println("¡Saludos!");
        });

        botonJugador.setOnAction(event -> {
            System.out.println("¡Hasta luego!");
        });

        // Agregar los botones al contenedor
        root.getChildren().addAll(botonMapa, botonGanar, botonJugador);

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
