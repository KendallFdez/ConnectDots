module com.example.connectdotsclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.connectdotsclient to javafx.fxml;
    exports com.example.connectdotsclient;
}