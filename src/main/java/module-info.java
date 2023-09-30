module client.interfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires org.json;
    requires org.apache.commons.lang3;
    requires RXTXcomm;
    requires java.desktop;

    opens client.interfaz to javafx.fxml;
    exports client.interfaz;

    opens client.interfaztest to javafx.fxml;
    exports server.modelo;
    exports utils.Doble;
    exports server;
    exports utils.Cola;
}