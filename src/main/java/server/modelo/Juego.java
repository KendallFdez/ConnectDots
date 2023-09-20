package server.modelo;
import utils.Doble.ListaDoble;
import utils.Doble.NodoDoble;

public class Juego {
    private ListaDoble<ListaDoble<Integer>> mallaLineasHorizontales;
    private ListaDoble<ListaDoble<Integer>> mallaLineasVerticales;
    private ListaDoble<ListaDoble<Integer>> cuadrados;

    public void Juego(){
        this.mallaLineasHorizontales = ConstruirMatrix(6, 7);
        this.mallaLineasVerticales = ConstruirMatrix(7, 6);
        this.cuadrados = ConstruirMatrix(6, 6);

    }

    public ListaDoble<ListaDoble<Integer>> ConstruirMatrix(int cantidadColumnas, int cantidadFilas){
        ListaDoble<ListaDoble<Integer>> matrix = new ListaDoble<>();

        for (int x=0; x < cantidadFilas; x++) {
            ListaDoble<Integer> fila = new ListaDoble<>();
            for (int y=0; y < cantidadColumnas; y++) {
                fila.insertLast(0);
            }
            matrix.insertLast(fila);
        }

        return matrix;
    }

    public boolean PonerLineaVertical(int elemento, int columnaIndex, int filaIndex){
        NodoDoble<ListaDoble<Integer>> fila = this.mallaLineasVerticales.obtenerNodoPorIndice(filaIndex);
        if (fila != null){
            NodoDoble<Integer> columna = fila.getData().obtenerNodoPorIndice(columnaIndex);
            if (columna != null){
                columna.setData(elemento);
                return true;
            }
        }

        return false;
    }
    public boolean PonerLineaHorizontal(int elemento, int columnaIndex, int filaIndex){
        NodoDoble<ListaDoble<Integer>> fila = this.mallaLineasHorizontales.obtenerNodoPorIndice(filaIndex);
        if (fila != null){
            NodoDoble<Integer> columna = fila.getData().obtenerNodoPorIndice(columnaIndex);
            if (columna != null){
                columna.setData(elemento);
                return true;
            }
        }
        return false;
    }

    /**
     * Valida los cuadros vacios, donde el elemento es 0 y las lineas alrededor están marcadas,
     * retorna los índices de los cuatros ganados
     * 6xfila + columna
     */
    public ListaDoble<Integer> ValidarCuadros(int elemento){

        return null;
    }
}

//Se necesita, poder recorrer, obtener, insertar






