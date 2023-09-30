package client.controller;

import client.Comandos;
import client.Juego;
import com.serialpundit.serial.SerialComManager;

import client.interfaz.GameController;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import utils.Doble.ListaDoble;
import utils.Doble.NodoDoble;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Controller implements Runnable {


    private GameController gameController;
    private boolean cerrar;

    private String botonPresionado = "";

    private long handle;

    private SerialComManager scm;


    public Controller(GameController gameController) {
        this.gameController = gameController;
        try {
            this.scm = new SerialComManager();
            this.handle = scm.openComPort("COM3", true, true, true);

            scm.configureComPortData(handle, SerialComManager.DATABITS.DB_8, SerialComManager.STOPBITS.SB_1, SerialComManager.PARITY.P_NONE, SerialComManager.BAUDRATE.B9600, 0);
            scm.configureComPortControl(handle, SerialComManager.FLOWCONTROL.NONE, 'x', 'x', false, false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void terminarEjecucion(){
        this.cerrar = true;
    }

    @Override
    public void run() {
        this.cerrar = false;

        try {

            while (!this.cerrar) {
                TimeUnit.MILLISECONDS.sleep(500);
                String received = scm.readString(handle);
                this.ejecutarTecla(received);
            }

            scm.closeComPort(handle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ObtenerNodoDerecho(int numeroLinea, String tipo){
        GameController gameController = new GameController();
        ListaDoble<Button> lineasHorizontales=gameController.getLineasHorizontales();
        ListaDoble<Button> lineasVerticales=gameController.getLineasVerticales();
        NodoDoble<Button> nodo = null;
        if(tipo.equals("horizontal"))
        {
            nodo = lineasHorizontales.obtenerNodoPorIndice(numeroLinea+1);
        }
        else
        {
            nodo = lineasVerticales.obtenerNodoPorIndice(numeroLinea+1);
        }
        try{
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void ObtenerNodoIzquierdo(int numeroLinea, String tipo){
        GameController gameController = new GameController();
        ListaDoble<Button> lineasHorizontales=gameController.getLineasHorizontales();
        ListaDoble<Button> lineasVerticales=gameController.getLineasVerticales();
        NodoDoble<Button> nodo = null;
        if(tipo.equals("horizontal"))
        {
            nodo = lineasHorizontales.obtenerNodoPorIndice(numeroLinea-1);
        }
        else
        {
            nodo = lineasVerticales.obtenerNodoPorIndice(numeroLinea+1);
        }
        try{
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void ObtenerNodoSuperior(int numeroLinea, String tipo){
        GameController gameController = new GameController();
        ListaDoble<Button> lineasHorizontales=gameController.getLineasHorizontales();
        ListaDoble<Button> lineasVerticales=gameController.getLineasVerticales();
        NodoDoble<Button> nodo = null;
        if(tipo.equals("horizontal"))
        {
            nodo = lineasHorizontales.obtenerNodoPorIndice(numeroLinea-6);
        }
        else
        {
            nodo = lineasVerticales.obtenerNodoPorIndice(numeroLinea-7);
        }
        try{
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void ObtenerNodoInferior(int numeroLinea, String tipo){
        GameController gameController = new GameController();
        ListaDoble<Button> lineasHorizontales=gameController.getLineasHorizontales();
        ListaDoble<Button> lineasVerticales=gameController.getLineasVerticales();
        NodoDoble<Button> nodo = null;
        if(tipo.equals("horizontal"))
        {
            nodo = lineasHorizontales.obtenerNodoPorIndice(numeroLinea+6);
        }
        else
        {
            nodo = lineasVerticales.obtenerNodoPorIndice(numeroLinea+7);
        }
        try{
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #ff0000; ");
            Thread.sleep(250);
            nodo.getData().setStyle("-fx-background-color: #FFFFFF; ");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void ejecutarTecla(String data) {
        if (data == null){
            return ;
        }
        try {
            data= new Scanner(data).useDelimiter("[^\\d]+").next();
            int dataValue = Integer.parseInt(data);
            TimeUnit.MILLISECONDS.sleep(500);
            if (dataValue % 0b10 == 1) {
                if(Juego.GetInstance().esMiTurno())
                {
                    //Juego.GetInstance().GetConnection().Enviar_mensaje(Comandos.GetComandoPonerLinea(index, tipo));
                }
                Platform.runLater(() -> {
                    System.out.println("Actualizando informacion");
                    this.gameController.seleccionarLinea(0, "horizontal");
                });
                this.botonPresionado = "S";
                System.out.println("boton presionado S");

            } else if ((dataValue / 0b10) % 0b10 == 1) {
                Platform.runLater(() -> {
                    this.gameController.seleccionarLinea(0, "vertical");
                    this.gameController.deseleccionarLinea(0, "vertical");
                });
                this.botonPresionado = "U";
                System.out.println("boton presionado U");

            } else if ((dataValue / 0b100) % 0b10 == 1) {
                this.botonPresionado = "D";
                System.out.println("boton presionado D");

            } else if ((dataValue / 0b1000) % 0b10 == 1) {
                this.botonPresionado = "R";
                System.out.println("boton presionado R");

            } else if (dataValue / 0b10000 == 1) {
                this.botonPresionado = "L";
                System.out.println("boton presionado L");
            }
        } catch (Exception e) {
            this.botonPresionado = "";
        }

    }
}

