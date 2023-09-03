package DoubleLinkedList;


/**
 * Clase listaDoble(doblemente enlazada) para implementar la malla del juego
 */
public class ListaDoble {
    /**
     * Representa el primer elemento de la lista
     */
    private NodoDoble head;
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
    public void insertLast(int value){
        NodoDoble newNode = new NodoDoble(value);
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
    public void insertFirst(int value){
        NodoDoble newNode = new NodoDoble(value);
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
        NodoDoble temp=head;
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
}
