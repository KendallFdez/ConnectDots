package utils.Cola;

/**
 * Clase nodo que contiene valores para añadirlos a una lista enlazada
 */
public class Nodo<T> {
    /**
     * Representa el valo del nodo
     */
    private T data;
    /**
     * Representa el nodo al que apunta este nodo(siguiente)
     */
    private Nodo<T> next;

    /**
     * Constructor del nodo
     * @param data el valor del nodo
     */
    public Nodo(T data) {//De momento hago el nodo para int porque no se con que se va trabajar todavia
        this.data = data;
        next = null;
    }

    /**
     * @return El valor del nodo
     */
    public T getData() {
        return data;
    }

    /**
     * @param data Cambia el valor del nodo
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return El siguiente nodo
     */
    public Nodo<T> getNext() {
        return next;
    }

    /**
     * @param next Cambia al nodo hacia el que apunta este nodo
     */
    public void setNext(Nodo<T> next) {
        this.next = next;
    }
}
