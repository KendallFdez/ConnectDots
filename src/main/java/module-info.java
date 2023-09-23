module client.interfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires org.json;


    opens client.interfaz to javafx.fxml;
    exports client.interfaz;

    opens client.interfaztest to javafx.fxml;
    exports client.interfaztest;
    exports server.modelo;
    exports utils.Doble;
}