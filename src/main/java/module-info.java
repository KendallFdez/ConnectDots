module com.example.connectdots {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires org.json;

    opens Client.interfaz to javafx.fxml;
    exports Client.interfaz;
}