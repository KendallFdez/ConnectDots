package Client.interfaz;

import Server.Doble.ListaDoble;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    ListaDoble<Button> fila0 = new ListaDoble<Button>();
    ListaDoble<Button> fila1 = new ListaDoble<Button>();
    ListaDoble<Button> fila2 = new ListaDoble<Button>();
    ListaDoble<Button> fila3= new ListaDoble<Button>();
    ListaDoble<Button> fila4 = new ListaDoble<Button>();
    ListaDoble<Button> fila5 = new ListaDoble<Button>();
    ListaDoble<Button> fila6 = new ListaDoble<Button>();
    ListaDoble<Button> fila7 = new ListaDoble<Button>();
    ListaDoble<Button> fila8 = new ListaDoble<Button>();
    ListaDoble<Button> fila9 = new ListaDoble<Button>();
    ListaDoble<Button> fila10 = new ListaDoble<Button>();
    ListaDoble<Button> fila11 = new ListaDoble<Button>();
    ListaDoble<Button> fila12 = new ListaDoble<Button>();

    ListaDoble<ListaDoble<Button>> matrizJuego = new ListaDoble<ListaDoble<Button>>();
    private void añadirFila0() {
        fila0.insertLast(boton1_0);
        fila0.insertLast(boton3_0);
        fila0.insertLast(boton5_0);
        fila0.insertLast(boton7_0);
        fila0.insertLast(boton9_0);
        fila0.insertLast(boton11_0);
    }
    private void añadirFila1() {
        fila1.insertLast(boton0_1);
        fila1.insertLast(boton2_1);
        fila1.insertLast(boton4_1);
        fila1.insertLast(boton6_1);
        fila1.insertLast(boton8_1);
        fila1.insertLast(boton10_1);
        fila1.insertLast(boton12_1);
    }
    private void añadirFila2() {
        fila2.insertLast(boton1_2);
        fila2.insertLast(boton3_2);
        fila2.insertLast(boton5_2);
        fila2.insertLast(boton7_2);
        fila2.insertLast(boton9_2);
        fila2.insertLast(boton11_2);
    }
    private void añadirFila3() {
        fila3.insertLast(boton0_3);
        fila3.insertLast(boton2_3);
        fila3.insertLast(boton4_3);
        fila3.insertLast(boton6_3);
        fila3.insertLast(boton8_3);
        fila3.insertLast(boton10_3);
        fila3.insertLast(boton12_3);
    }
    private void añadirFila4() {
        fila4.insertLast(boton1_4);
        fila4.insertLast(boton3_4);
        fila4.insertLast(boton5_4);
        fila4.insertLast(boton7_4);
        fila4.insertLast(boton9_4);
        fila4.insertLast(boton11_4);
    }
    private void añadirFila5() {
        fila5.insertLast(boton0_5);
        fila5.insertLast(boton2_5);
        fila5.insertLast(boton4_5);
        fila5.insertLast(boton6_5);
        fila5.insertLast(boton8_5);
        fila5.insertLast(boton10_5);
        fila5.insertLast(boton12_5);
    }
    private void añadirFila6() {
        fila6.insertLast(boton1_6);
        fila6.insertLast(boton3_6);
        fila6.insertLast(boton5_6);
        fila6.insertLast(boton7_6);
        fila6.insertLast(boton9_6);
        fila6.insertLast(boton11_6);
    }
    private void añadirFila7() {
        fila7.insertLast(boton0_7);
        fila7.insertLast(boton2_7);
        fila7.insertLast(boton4_7);
        fila7.insertLast(boton6_7);
        fila7.insertLast(boton8_7);
        fila7.insertLast(boton10_7);
        fila7.insertLast(boton12_7);
    }
    private void añadirFila8() {
        fila8.insertLast(boton1_8);
        fila8.insertLast(boton3_8);
        fila8.insertLast(boton5_8);
        fila8.insertLast(boton7_8);
        fila8.insertLast(boton9_8);
        fila8.insertLast(boton11_8);
    }
    private void añadirFila9() {
        fila9.insertLast(boton0_9);
        fila9.insertLast(boton2_9);
        fila9.insertLast(boton4_9);
        fila9.insertLast(boton6_9);
        fila9.insertLast(boton8_9);
        fila9.insertLast(boton10_9);
        fila9.insertLast(boton12_9);
    }
    private void añadirFila10() {
        fila10.insertLast(boton1_10);
        fila10.insertLast(boton3_10);
        fila10.insertLast(boton5_10);
        fila10.insertLast(boton7_10);
        fila10.insertLast(boton9_10);
        fila10.insertLast(boton11_10);
    }
    private void añadirFila11() {
        fila11.insertLast(boton0_11);
        fila11.insertLast(boton2_11);
        fila11.insertLast(boton4_11);
        fila11.insertLast(boton6_11);
        fila11.insertLast(boton8_11);
        fila11.insertLast(boton10_11);
        fila11.insertLast(boton12_11);
    }
    private void añadirFila12() {
        fila12.insertLast(boton1_12);
        fila12.insertLast(boton3_12);
        fila12.insertLast(boton5_12);
        fila12.insertLast(boton7_12);
        fila12.insertLast(boton9_12);
        fila12.insertLast(boton11_12);
    }
    private void añadirMatriz() {
        matrizJuego.insertLast(fila1);
        matrizJuego.insertLast(fila2);
        matrizJuego.insertLast(fila3);
        matrizJuego.insertLast(fila4);
        matrizJuego.insertLast(fila5);
        matrizJuego.insertLast(fila6);
        matrizJuego.insertLast(fila7);
        matrizJuego.insertLast(fila8);
        matrizJuego.insertLast(fila9);
        matrizJuego.insertLast(fila10);
        matrizJuego.insertLast(fila11);
        matrizJuego.insertLast(fila12);
    }

    public void largoMatriz() {
        System.out.println(matrizJuego.getLength());
        añadirMatriz();
        System.out.println(matrizJuego.getLength());
        matrizJuego.displayForward();
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

}
