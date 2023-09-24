package utils.Doble;


import utils.Cola.Nodo;

/**
 * Clase listaDoble(doblemente enlazada) para implementar la malla del juego
 */
public class ListaDoble<T> {
    /**
     * Representa el primer elemento de la lista
     */
    private NodoDoble<T> head;

    public NodoDoble<T> getHead() {
        return head;
    }

    /**
     * Representa el ultimo elemento de la lista
     */
    private NodoDoble tail;
    /**
     * Representa el largo de la lista
     */
    private int length;

    /**
     * Constructor
     */
    public ListaDoble(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    /**
     * @return Si la lista esta vacia
     */
    public boolean isEmpty(){
        return length==0;
    }

    /**
     * @return El largo de la lista
     */
    public int getLength(){
        return length;
    }

    /**
     * Inseta al final de la lista
     * @param value el valor a insertar
     */
    public void insertLast(T value){
        NodoDoble<T> newNode = new NodoDoble<T>(value);
        if(isEmpty()){
            head=newNode;
            tail=newNode;
        }else{
            tail.setNext(newNode);
        }
        newNode.setPrevious(tail);
        tail=newNode;
        length++;
    }

    /**
     * Inserta al principio de la lista
     * @param value el valor a insertar
     */
    public void insertFirst(T value){
        NodoDoble<T> newNode = new NodoDoble<T>(value);
        if(isEmpty()) {
            tail = newNode;
            head = newNode;
        }else{
            head.setPrevious(newNode);
        }
        newNode.setNext(head);
        head=newNode;
        length++;
    }

    /**
     * Elimina al principio de la lista
     */
    public void deleteFirst(){
        if(isEmpty()){
            System.out.println("Lista vacia");
        }
        NodoDoble temp=head;
        if(head==tail){
            tail=null;
            head=null;
        }else {
            head.getNext().setPrevious(null);
        }
        head=head.getNext();
        temp.setNext(null);
        length--;
        System.out.println("Se elimino "+temp.getData());
    }

    /**
     * Elimina al final de la lista
     */
    public void deleteLast(){
        if(isEmpty()){
            System.out.println("Lista vacia");
        }
        NodoDoble temp=tail;
        if(head==tail){
            tail=null;
            head=null;
        }else {
            tail.getPrevious().setNext(null);
        }
        tail=tail.getPrevious();
        temp.setPrevious(null);
        length--;
        System.out.println("Se elimino "+temp.getData());
    }

    /**
     * Imprime la lista
     */
    public void displayForward(){
        if(head==null){
            return;
        }
        NodoDoble<T> temp=head;
        System.out.print("[");
        while (temp != null) {
            if(temp.getNext()!=null) {
                System.out.print(temp.getData() + ",");
                temp = temp.getNext();
            }else{
                System.out.print(temp.getData() + "]");
                temp = temp.getNext();
            }
        }
    }

    public NodoDoble<T> obtenerNodoPorIndice(int i){
        if(i<0){
            return null;
        }
        NodoDoble<T> temp=head;
        while (temp != null) {
            if(i==0) {
                return temp;
            }
            if(temp.getNext()!=null) {
                i--;
                temp = temp.getNext();
            }
        }
        return null;
    }
    public int getNodePosition(T data) {
        NodoDoble<T> current = head;
        int position = 1;
        while (current != null) {
            if (current.getData().equals(data)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // node not found
    }
}

