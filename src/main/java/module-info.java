module com.example.connectdots {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens interfaz.connectdots to javafx.fxml;
    exports interfaz.connectdots;
}