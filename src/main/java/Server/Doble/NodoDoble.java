package Server.Doble;
/**
 * Clase nodo que contiene valores para añadirlos a una lista doblemente enlazada
 */
public class NodoDoble {
    /**
     * Representa el valo del nodo
     */
    int data;
    /**
     * Representa el nodo que esta antes de este nodo
     */
    NodoDoble previous;
    /**
     * Representa el nodo que le sigue a este nodo
     */
    NodoDoble next;

    /**
     * Constructor del nodo
     * @param data el valor del nodo
     */
    public NodoDoble(int data){
        this.data = data;
        next = null;
        previous = null;
    }

    /**
     * @return Devuelve el valor del nodo
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
     * @return Devuelve el nodo anterior
     */
    public NodoDoble getPrevious() {
        return previous;
    }

    /**
     * @param previous Cambia el nodo que esta antes
     */
    public void setPrevious(NodoDoble previous) {
        this.previous = previous;
    }

    /**
     * @return Devuelve el nodo siguiente
     */
    public NodoDoble getNext() {
        return next;
    }

    /**
     * @param next Cambia el nodo que sigue
     */
    public void setNext(NodoDoble next) {
        this.next = next;
    }

}
