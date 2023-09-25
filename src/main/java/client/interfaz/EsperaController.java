package client.interfaz;

import client.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Doble.ListaDoble;

public class EsperaController {
    ListaDoble<String> jugadores = new ListaDoble<String>();
    @FXML
    private Button aceptarNombre;
    @FXML
    private Button botonAbrir;
    @FXML
    private Button verPosicion;

    @FXML
    private TextField campoNombre;

    @FXML
    private Label posicionCola;

    public Stage gameControllerStage;


    @FXML
    public void actualizarPosicion(ActionEvent event){
        posicionCola.setText(String.valueOf(jugadores.getNodePosition(campoNombre.getText())));
        System.out.println(jugadores.getNodePosition(campoNombre.getText()));
    }
    public ListaDoble<String> getJugadores() {
        return jugadores;
    }

    public void CambiarPantalla(String nombre, GameController gameController)
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game1.fxml"));
            Stage stage= new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 624, 750);
            stage.setTitle("Connect Dots");
            stage.setScene(scene);
            stage.show();
            this.gameControllerStage = stage;

            gameController = fxmlLoader.getController();
            Juego.GetInstance().setGameController(gameController);
            gameController.cambiarNombre(nombre);
            gameController.cambiarUsuarioActual(Juego.GetInstance().getUsuario().getNombre());
            gameController.configurarPantalla();
        }catch (Exception e){
            System.out.println("No se puede inicar la ventana del juego");
            System.out.println(e.toString());
        }

    }
    @FXML
    public void iniciarJuego(ActionEvent event) {
        if(campoNombre.getText().isEmpty())
        {
            return;
        }

        Juego.GetInstance().Conectarse(campoNombre.getText());

        String nombreUsuario = campoNombre.getText();
        campoNombre.setDisable(true);
        botonAbrir.setText("Esperando mas jugadores");
        botonAbrir.setPrefWidth(140);
        botonAbrir.setLayoutX(230);
        botonAbrir.setDisable(true);
        Juego.GetInstance().setEsperaController(this);
    }

    public void resetWindow()
    {
        this.gameControllerStage.close();
        campoNombre.setDisable(false);
        botonAbrir.setText("Conectarse");
        botonAbrir.setPrefWidth(70);
        botonAbrir.setLayoutX(266);
        botonAbrir.setDisable(false);
    }
}
