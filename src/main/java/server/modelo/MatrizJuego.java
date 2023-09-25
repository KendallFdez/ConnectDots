package server.modelo;
import utils.Doble.ListaDoble;
import utils.Doble.NodoDoble;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class MatrizJuego {
    private ListaDoble<ListaDoble<Integer>> mallaLineasHorizontales;
    private ListaDoble<ListaDoble<Integer>> mallaLineasVerticales;
    private ListaDoble<ListaDoble<Integer>> cuadrados;

    private int cantidadCuadrosRellenados = 0;

    private HashMap<Integer, Integer> cantidadCuadrosPorUsuario;


    public MatrizJuego(){
        this.mallaLineasHorizontales = ConstruirMatrix(6, 7);
        this.mallaLineasVerticales = ConstruirMatrix(7, 6);
        this.cuadrados = ConstruirMatrix(6, 6);
        this.cantidadCuadrosPorUsuario = new HashMap<>();

    }

    public ListaDoble<ListaDoble<Integer>> ConstruirMatrix(int cantidadColumnas, int cantidadFilas){
        ListaDoble<ListaDoble<Integer>> matrix = new ListaDoble<>();

        for (int x=0; x < cantidadFilas; x++) {
            ListaDoble<Integer> fila = new ListaDoble<>();
            for (int y=0; y < cantidadColumnas; y++) {
                fila.insertLast(-1);
            }
            matrix.insertLast(fila);
        }

        return matrix;
    }

    public boolean PonerLineaVertical(int elemento, int numeroLineaHorizontal){
        int filaIndex = numeroLineaHorizontal / 7;
        int columnaIndex = numeroLineaHorizontal % 7;
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
    public boolean PonerLineaHorizontal(int elemento, int numeroLineaHorizontal){
        int filaIndex = numeroLineaHorizontal / 6;
        int columnaIndex = numeroLineaHorizontal % 6;
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

    public int ObtenerUsuarioGanador(){
        int userId = -1;
        int cantidadCuadros = 0;
        int cantidadUsuariosConMismaPuntacion = 0;
        if(this.cantidadCuadrosRellenados < 36)
        {
            return userId;
        }

        for (HashMap.Entry<Integer, Integer> entry : this.cantidadCuadrosPorUsuario.entrySet())
        {
            if(entry.getValue() > cantidadCuadros)
            {
                userId = entry.getKey();
                cantidadCuadros = entry.getValue();
                cantidadUsuariosConMismaPuntacion = 1;
            } else if (entry.getValue() == cantidadCuadros && cantidadCuadros > 0) {
                cantidadUsuariosConMismaPuntacion ++;
            }
        }

        if(cantidadUsuariosConMismaPuntacion > 1)
        {
            return -2;
        }

        return  userId;
    }

    /**
     * Valida los cuadros vacios, donde el elemento es 0 y las lineas alrededor están marcadas,
     * retorna los índices de los cuatros ganados
     * 6xfila + columna
     */
    public ListaDoble<Integer> ValidarCuadros(int elemento){
        int numeroCuadro = 0;
        ListaDoble<Integer> cuadradosRellenados = new ListaDoble<>();
        NodoDoble<ListaDoble<Integer>> filaActual = this.cuadrados.getHead();
        for (int x=0; x < this.cuadrados.getLength(); x++) {
            NodoDoble<Integer> casillaActual = filaActual.getData().getHead();
            for (int y=0; y < filaActual.getData().getLength(); y++) {
                if(casillaActual.getData() == -1 && this.validarCuadrado(x, y))
                {
                    casillaActual.setData(elemento);
                    cuadradosRellenados.insertLast(x*6 + y);
                    if(this.cantidadCuadrosPorUsuario.containsKey(elemento))
                    {
                        this.cantidadCuadrosPorUsuario.put(elemento, this.cantidadCuadrosPorUsuario.get(elemento)+1);
                    }else
                    {
                        this.cantidadCuadrosPorUsuario.put(elemento, 1);
                    }

                    this.cantidadCuadrosRellenados ++;
                }
                casillaActual = casillaActual.getNext();
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
        return verticalIzq > -1 && verticalDr > -1 && horizontalSup > -1 && horizontalInf > -1;
    }

    private int obtenerCasillaMatriz(int fila, int columna, ListaDoble<ListaDoble<Integer>> matriz){
        return matriz.obtenerNodoPorIndice(fila).getData().obtenerNodoPorIndice(columna).getData();
    }
}

//Se necesita, poder recorrer, obtener, insertar






