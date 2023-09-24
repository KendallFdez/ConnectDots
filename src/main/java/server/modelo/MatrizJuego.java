package server.modelo;
import utils.Doble.ListaDoble;
import utils.Doble.NodoDoble;

public class MatrizJuego {
    private ListaDoble<ListaDoble<Integer>> mallaLineasHorizontales;
    private ListaDoble<ListaDoble<Integer>> mallaLineasVerticales;
    private ListaDoble<ListaDoble<Integer>> cuadrados;

    public MatrizJuego(){
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
        ListaDoble<Integer> cuadradosRellenados = new ListaDoble<>();
        NodoDoble<ListaDoble<Integer>> filaActual = this.cuadrados.getHead();
        for (int x=0; x < this.cuadrados.getLength(); x++) {
            NodoDoble<Integer> casillaActual = filaActual.getData().getHead();
            for (int y=0; y < filaActual.getData().getLength(); y++) {
                if(this.validarCuadrado(x, y))
                {
                    casillaActual.setData(elemento);
                    cuadradosRellenados.insertLast(elemento);
                }
            }
            filaActual = filaActual.getNext();
        }
        return cuadradosRellenados;
    }

    private boolean validarCuadrado(int fila, int columna)
    {
        int verticalIzq = this.obtenerCasillaMatriz(fila, columna, this.mallaLineasVerticales);
        int verticalDr = this.obtenerCasillaMatriz(fila, columna + 1, this.mallaLineasVerticales);
        int horizontalSup = this.obtenerCasillaMatriz(fila, columna, this.mallaLineasHorizontales);
        int horizontalInf = this.obtenerCasillaMatriz(fila + 1, columna, this.mallaLineasHorizontales);
        return verticalIzq > 0 && verticalDr > 0 && horizontalSup > 0 && horizontalInf > 0;
    }

    private int obtenerCasillaMatriz(int fila, int columna, ListaDoble<ListaDoble<Integer>> matriz){
        return matriz.obtenerNodoPorIndice(fila).getData().obtenerNodoPorIndice(columna).getData();
    }
}

//Se necesita, poder recorrer, obtener, insertar






