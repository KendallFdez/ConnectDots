package Utils.Cola;

/**
 * Clase nodo que contiene valores para añadirlos a una lista enlazada
 */
public class Nodo {
    /**
     * Representa el valo del nodo
     */
    private int data;
    /**
     * Representa el nodo al que apunta este nodo(siguiente)
     */
    private Nodo next;

    /**
     * Constructor del nodo
     * @param data el valor del nodo
     */
    public Nodo(int data) {//De momento hago el nodo para int porque no se con que se va trabajar todavia
        this.data = data;
        next = null;
    }

    /**
     * @return El valor del nodo
     */
    public int getData() {
        return data;
    }

    /**
     * @param data Cambia el valor del nodo
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return El siguiente nodo
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next Cambia al nodo hacia el que apunta este nodo
     */
    public void setNext(Nodo next) {
        this.next = next;
    }
}
