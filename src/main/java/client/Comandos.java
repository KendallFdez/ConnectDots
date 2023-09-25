package client;

import client.Model.Usuario;

public class Comandos {


    public static String GetComandoConexion(String nombre)
    {
        return "{\"comando\":\"conexion\",\"nombre\":\"%s\"}".formatted(nombre);
    }

    public static String GetComandoPonerLinea(int numeroLinea, String tipo)
    {
        return "{\"comando\":\"ponerLinea\",\"numeroLinea\":\"%d\",\"tipo\":\"%s\"}".formatted(numeroLinea, tipo);
    }

    public static String GetComandoEstadoListas(Usuario usuario)
    {
        return "{\"comando\":\"estadoListas\"}";
    }


}
