package client.interfaz;

import client.Comandos;
import client.Juego;
import javafx.event.ActionEvent;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import utils.Doble.ListaDoble;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import utils.Doble.NodoDoble;
import javafx.scene.control.ButtonBar.ButtonData;

import java.util.Optional;

public class GameController {

    ListaDoble<Label> listaCuadros = new ListaDoble<Label>();
    ListaDoble<Button> lineasVerticales = new ListaDoble<Button>();
    ListaDoble<Button> lineasHorizontales = new ListaDoble<Button>();

    public void configurarCambiarColor(ListaDoble<Button> botones, String tipo)
    {
        NodoDoble<Button> nodoDoble = botones.getHead();
        int index = 0;
        while(nodoDoble != null)
        {
            this.cambiarColor(nodoDoble.getData(), index, tipo);
            index ++;
            nodoDoble = nodoDoble.getNext();
        }
    }

    public void configurarPantalla()
    {
        this.configurarLineasHorizontales();
        this.configurarLineasVerticales();
        this.configurarCuadros();
        this.configurarCambiarColor(this.lineasHorizontales, "horizontal");
        this.configurarCambiarColor(this.lineasVerticales, "vertical");
    }
    private void configurarLineasHorizontales() {
        //fila horizontales 1
        lineasHorizontales.insertLast(boton1_0);
        lineasHorizontales.insertLast(boton3_0);
        lineasHorizontales.insertLast(boton5_0);
        lineasHorizontales.insertLast(boton7_0);
        lineasHorizontales.insertLast(boton9_0);
        lineasHorizontales.insertLast(boton11_0);

        //fila horizontales 2
        lineasHorizontales.insertLast(boton1_2);
        lineasHorizontales.insertLast(boton3_2);
        lineasHorizontales.insertLast(boton5_2);
        lineasHorizontales.insertLast(boton7_2);
        lineasHorizontales.insertLast(boton9_2);
        lineasHorizontales.insertLast(boton11_2);

        //fila horizontales 3
        lineasHorizontales.insertLast(boton1_4);
        lineasHorizontales.insertLast(boton3_4);
        lineasHorizontales.insertLast(boton5_4);
        lineasHorizontales.insertLast(boton7_4);
        lineasHorizontales.insertLast(boton9_4);
        lineasHorizontales.insertLast(boton11_4);

        //fila horizontales 4
        lineasHorizontales.insertLast(boton1_6);
        lineasHorizontales.insertLast(boton3_6);
        lineasHorizontales.insertLast(boton5_6);
        lineasHorizontales.insertLast(boton7_6);
        lineasHorizontales.insertLast(boton9_6);
        lineasHorizontales.insertLast(boton11_6);

        //fila horizontales 5
        lineasHorizontales.insertLast(boton1_8);
        lineasHorizontales.insertLast(boton3_8);
        lineasHorizontales.insertLast(boton5_8);
        lineasHorizontales.insertLast(boton7_8);
        lineasHorizontales.insertLast(boton9_8);
        lineasHorizontales.insertLast(boton11_8);

        //fila horizontales 6
        lineasHorizontales.insertLast(boton1_10);
        lineasHorizontales.insertLast(boton3_10);
        lineasHorizontales.insertLast(boton5_10);
        lineasHorizontales.insertLast(boton7_10);
        lineasHorizontales.insertLast(boton9_10);
        lineasHorizontales.insertLast(boton11_10);

        //fila horizontales 7
        lineasHorizontales.insertLast(boton1_12);
        lineasHorizontales.insertLast(boton3_12);
        lineasHorizontales.insertLast(boton5_12);
        lineasHorizontales.insertLast(boton7_12);
        lineasHorizontales.insertLast(boton9_12);
        lineasHorizontales.insertLast(boton11_12);
    }
    private void configurarLineasVerticales() {
        //fila verticales 1
        lineasVerticales.insertLast(boton0_1);
        lineasVerticales.insertLast(boton2_1);
        lineasVerticales.insertLast(boton4_1);
        lineasVerticales.insertLast(boton6_1);
        lineasVerticales.insertLast(boton8_1);
        lineasVerticales.insertLast(boton10_1);
        lineasVerticales.insertLast(boton12_1);

        //fila verticales 2
        lineasVerticales.insertLast(boton0_3);
        lineasVerticales.insertLast(boton2_3);
        lineasVerticales.insertLast(boton4_3);
        lineasVerticales.insertLast(boton6_3);
        lineasVerticales.insertLast(boton8_3);
        lineasVerticales.insertLast(boton10_3);
        lineasVerticales.insertLast(boton12_3);

        //fila verticales 3
        lineasVerticales.insertLast(boton0_5);
        lineasVerticales.insertLast(boton2_5);
        lineasVerticales.insertLast(boton4_5);
        lineasVerticales.insertLast(boton6_5);
        lineasVerticales.insertLast(boton8_5);
        lineasVerticales.insertLast(boton10_5);
        lineasVerticales.insertLast(boton12_5);

        //fila verticales 4
        lineasVerticales.insertLast(boton0_7);
        lineasVerticales.insertLast(boton2_7);
        lineasVerticales.insertLast(boton4_7);
        lineasVerticales.insertLast(boton6_7);
        lineasVerticales.insertLast(boton8_7);
        lineasVerticales.insertLast(boton10_7);
        lineasVerticales.insertLast(boton12_7);

        //fila verticales 5
        lineasVerticales.insertLast(boton0_9);
        lineasVerticales.insertLast(boton2_9);
        lineasVerticales.insertLast(boton4_9);
        lineasVerticales.insertLast(boton6_9);
        lineasVerticales.insertLast(boton8_9);
        lineasVerticales.insertLast(boton10_9);
        lineasVerticales.insertLast(boton12_9);

        //fila verticales 6
        lineasVerticales.insertLast(boton0_11);
        lineasVerticales.insertLast(boton2_11);
        lineasVerticales.insertLast(boton4_11);
        lineasVerticales.insertLast(boton6_11);
        lineasVerticales.insertLast(boton8_11);
        lineasVerticales.insertLast(boton10_11);
        lineasVerticales.insertLast(boton12_11);

    }

    private void configurarCuadros() {
        //fila cuadros 1
        listaCuadros.insertLast(nombreCuadrado1_1);
        listaCuadros.insertLast(nombreCuadrado3_1);
        listaCuadros.insertLast(nombreCuadrado5_1);
        listaCuadros.insertLast(nombreCuadrado7_1);
        listaCuadros.insertLast(nombreCuadrado9_1);
        listaCuadros.insertLast(nombreCuadrado11_1);

        //fila cuadros 2
        listaCuadros.insertLast(nombreCuadrado1_3);
        listaCuadros.insertLast(nombreCuadrado3_3);
        listaCuadros.insertLast(nombreCuadrado5_3);
        listaCuadros.insertLast(nombreCuadrado7_3);
        listaCuadros.insertLast(nombreCuadrado9_3);
        listaCuadros.insertLast(nombreCuadrado11_3);

        //fila cuadros 3
        listaCuadros.insertLast(nombreCuadrado1_5);
        listaCuadros.insertLast(nombreCuadrado3_5);
        listaCuadros.insertLast(nombreCuadrado5_5);
        listaCuadros.insertLast(nombreCuadrado7_5);
        listaCuadros.insertLast(nombreCuadrado9_5);
        listaCuadros.insertLast(nombreCuadrado11_5);

        //fila cuadros 4
        listaCuadros.insertLast(nombreCuadrado1_7);
        listaCuadros.insertLast(nombreCuadrado3_7);
        listaCuadros.insertLast(nombreCuadrado5_7);
        listaCuadros.insertLast(nombreCuadrado7_7);
        listaCuadros.insertLast(nombreCuadrado9_7);
        listaCuadros.insertLast(nombreCuadrado11_7);

        //fila cuadros 5
        listaCuadros.insertLast(nombreCuadrado1_9);
        listaCuadros.insertLast(nombreCuadrado3_9);
        listaCuadros.insertLast(nombreCuadrado5_9);
        listaCuadros.insertLast(nombreCuadrado7_9);
        listaCuadros.insertLast(nombreCuadrado9_9);
        listaCuadros.insertLast(nombreCuadrado11_9);

        //fila cuadros 6
        listaCuadros.insertLast(nombreCuadrado1_11);
        listaCuadros.insertLast(nombreCuadrado3_11);
        listaCuadros.insertLast(nombreCuadrado5_11);
        listaCuadros.insertLast(nombreCuadrado7_11);
        listaCuadros.insertLast(nombreCuadrado9_11);
        listaCuadros.insertLast(nombreCuadrado11_11);
    }


    @FXML
    private Button boton0_1;

    @FXML
    private Button boton0_11;

    @FXML
    private Button boton0_3;

    @FXML
    private Button boton0_5;

    @FXML
    private Button boton0_7;

    @FXML
    private Button boton0_9;

    @FXML
    private Button boton10_1;

    @FXML
    private Button boton10_11;

    @FXML
    private Button boton10_3;

    @FXML
    private Button boton10_5;

    @FXML
    private Button boton10_7;

    @FXML
    private Button boton10_9;

    @FXML
    private Button boton11_0;

    @FXML
    private Button boton11_10;

    @FXML
    private Button boton11_12;

    @FXML
    private Button boton11_2;

    @FXML
    private Button boton11_4;

    @FXML
    private Button boton11_6;

    @FXML
    private Button boton11_8;

    @FXML
    private Button boton12_1;

    @FXML
    private Button boton12_11;

    @FXML
    private Button boton12_3;

    @FXML
    private Button boton12_5;

    @FXML
    private Button boton12_7;

    @FXML
    private Button boton12_9;

    @FXML
    private Button boton1_0;

    @FXML
    private Button boton1_10;

    @FXML
    private Button boton1_12;

    @FXML
    private Button boton1_2;

    @FXML
    private Button boton1_4;

    @FXML
    private Button boton1_6;

    @FXML
    private Button boton1_8;

    @FXML
    private Button boton2_1;

    @FXML
    private Button boton2_11;

    @FXML
    private Button boton2_3;

    @FXML
    private Button boton2_5;

    @FXML
    private Button boton2_7;

    @FXML
    private Button boton2_9;

    @FXML
    private Button boton3_0;

    @FXML
    private Button boton3_10;

    @FXML
    private Button boton3_12;

    @FXML
    private Button boton3_2;

    @FXML
    private Button boton3_4;

    @FXML
    private Button boton3_6;

    @FXML
    private Button boton3_8;

    @FXML
    private Button boton4_1;

    @FXML
    private Button boton4_11;

    @FXML
    private Button boton4_3;

    @FXML
    private Button boton4_5;

    @FXML
    private Button boton4_7;

    @FXML
    private Button boton4_9;

    @FXML
    private Button boton5_0;

    @FXML
    private Button boton5_10;

    @FXML
    private Button boton5_12;

    @FXML
    private Button boton5_2;

    @FXML
    private Button boton5_4;

    @FXML
    private Button boton5_6;

    @FXML
    private Button boton5_8;

    @FXML
    private Button boton6_1;

    @FXML
    private Button boton6_11;

    @FXML
    private Button boton6_3;

    @FXML
    private Button boton6_5;

    @FXML
    private Button boton6_7;

    @FXML
    private Button boton6_9;

    @FXML
    private Button boton7_0;

    @FXML
    private Button boton7_10;

    @FXML
    private Button boton7_12;

    @FXML
    private Button boton7_2;

    @FXML
    private Button boton7_4;

    @FXML
    private Button boton7_6;

    @FXML
    private Button boton7_8;

    @FXML
    private Button boton8_1;

    @FXML
    private Button boton8_11;

    @FXML
    private Button boton8_3;

    @FXML
    private Button boton8_5;

    @FXML
    private Button boton8_7;

    @FXML
    private Button boton8_9;

    @FXML
    private Button boton9_0;

    @FXML
    private Button boton9_10;

    @FXML
    private Button boton9_12;

    @FXML
    private Button boton9_2;

    @FXML
    private Button boton9_4;

    @FXML
    private Button boton9_6;

    @FXML
    private Button boton9_8;


    @FXML
    private Label nombreCuadrado11_1;

    @FXML
    private Label nombreCuadrado11_11;

    @FXML
    private Label nombreCuadrado11_3;

    @FXML
    private Label nombreCuadrado11_5;

    @FXML
    private Label nombreCuadrado11_7;

    @FXML
    private Label nombreCuadrado11_9;

    @FXML
    private Label nombreCuadrado1_1;

    @FXML
    private Label nombreCuadrado1_11;

    @FXML
    private Label nombreCuadrado1_3;

    @FXML
    private Label nombreCuadrado1_5;

    @FXML
    private Label nombreCuadrado1_7;

    @FXML
    private Label nombreCuadrado1_9;

    @FXML
    private Label nombreCuadrado3_1;

    @FXML
    private Label nombreCuadrado3_11;

    @FXML
    private Label nombreCuadrado3_3;

    @FXML
    private Label nombreCuadrado3_5;

    @FXML
    private Label nombreCuadrado3_7;

    @FXML
    private Label nombreCuadrado3_9;

    @FXML
    private Label nombreCuadrado5_1;

    @FXML
    private Label nombreCuadrado5_11;

    @FXML
    private Label nombreCuadrado5_3;

    @FXML
    private Label nombreCuadrado5_5;

    @FXML
    private Label nombreCuadrado5_7;

    @FXML
    private Label nombreCuadrado5_9;

    @FXML
    private Label nombreCuadrado7_1;

    @FXML
    private Label nombreCuadrado7_11;

    @FXML
    private Label nombreCuadrado7_3;

    @FXML
    private Label nombreCuadrado7_5;

    @FXML
    private Label nombreCuadrado7_7;

    @FXML
    private Label nombreCuadrado7_9;

    @FXML
    private Label nombreCuadrado9_1;

    @FXML
    private Label nombreCuadrado9_11;

    @FXML
    private Label nombreCuadrado9_3;

    @FXML
    private Label nombreCuadrado9_5;

    @FXML
    private Label nombreCuadrado9_7;

    @FXML
    private Label nombreCuadrado9_9;
    @FXML
    private Button botonVerListas;
    @FXML
    private Label personaTurno;

    @FXML
    private Label nombreJugador;


    protected void cambiarColor(Button boton, int index, String tipo) {
        boton.setOnAction(event->{
            if(Juego.GetInstance().esMiTurno())
            {
                Juego.GetInstance().GetConnection().Enviar_mensaje(Comandos.GetComandoPonerLinea(index, tipo));
            }
        });
    }
    public Dialog<String> CreateDialog(String name)
    {
        //Creating a dialog
        Dialog<String> dialog = new Dialog<String>();
        //Setting the title
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Finalizar", ButtonData.FINISH);
        //Setting the content of the dialog
        dialog.setContentText("Ganador: %s\nClick en el botón Finalizar para continuar a la pantalla inicial.".formatted(name));
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        //Setting the label
        return dialog;
    }



    @FXML
    public void VerListas(ActionEvent actionEvent) {

    }
    public void cambiarNombre(String nombreUsuario) {
        personaTurno.setText(nombreUsuario);
    }

    public void cambiarUsuarioActual(String nombreUsuario) {
        nombreJugador.setText(nombreUsuario);
    }

    public void ponerNombreCuadro(int numeroCuadro, String nombreUsuario) {
        NodoDoble<Label> nodo = this.listaCuadros.obtenerNodoPorIndice(numeroCuadro);
        nodo.getData().setText(nombreUsuario);
    }

    public void ponerLinea(int numeroLinea, String tipo) {
        NodoDoble<Button> nodo = null;
        if(tipo.equals("horizontal"))
        {
            nodo = this.lineasHorizontales.obtenerNodoPorIndice(numeroLinea);
        }
        else
        {
            nodo = this.lineasVerticales.obtenerNodoPorIndice(numeroLinea);
        }

        nodo.getData().setStyle("-fx-background-color: #ff0000; ");
        nodo.getData().setDisable(true);
    }
    public void verListas(ActionEvent actionEvent) {

    }

}
