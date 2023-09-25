package server;

import server.modelo.Cliente;
import utils.Doble.ListaDoble;
import utils.Doble.NodoDoble;

public class Comandos {
    public static String GetComandoConexion(int usuarioId)
    {
        return "{\"comando\":\"conexion\",\"id\":\"%d\"}".formatted(usuarioId);
    }

    public static String GetComandoServerIniciado(int usuarioId, String nombreUsuario)
    {
        return "{\"comando\":\"serverIniciado\",\"idTurnoActual\":\"%d\",\"nombreUsuario\":\"%s\"}".formatted(usuarioId,nombreUsuario);
    }

    public static String GetComandoActualizarCuadros(int numeroLinea,
                                                     String tipo,
                                                     Cliente usuarioActual,
                                                     ListaDoble<Integer> cuadros,
                                                     int siguienteJugadorId,
                                                     String siguienteJugadorNombre,
                                                     String juegoEstado
                                                     )
    {
        return """
                {"comando":"actualizarInformacion",
                 "numeroLinea": "%d",
                 "tipo": "%s",
                 "nombreActual":"%s",
                 "cuadros": %s,
                 "estado": "%s",
                 "idSigJugador": "%d",
                 "nombreSigJugador": "%s",
                }
                """.formatted(numeroLinea,
                tipo,
                usuarioActual.getNombre(),
                GenerarCuadros(cuadros),
                juegoEstado,
                siguienteJugadorId,
                siguienteJugadorNombre

                );

    }
    private static String GenerarCuadros(ListaDoble<Integer> listaDoble){
        StringBuilder jsonBuilder = new StringBuilder("[");
        NodoDoble<Integer> nodoActual = listaDoble.getHead();
        while(nodoActual != null)
        {
            jsonBuilder.append(nodoActual.getData());
            nodoActual = nodoActual.getNext();
            if(nodoActual != null)
            {
                jsonBuilder.append(", ");
            }

        }
        jsonBuilder.append("]");

        return jsonBuilder.toString();
    }

}
