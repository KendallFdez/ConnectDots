package utils.Cola;

/**
 * Clase cola para poner a los jugadores que buscan partida
 */
public class Cola {
    /**
     * Representa el ultimo elmento de la cola
     */
    private Nodo rear;
    /**
     * Representa el primer elmento de la cola
     */
    private Nodo front;
    /**
     * Representa la cantidad de elementos de la cola
     */
    private int size;

    /**
     * @return Si la cola esta vacia
     */
    public boolean isEmpty() {
        boolean vacio=false;
        if(size==0) {
            vacio=true;
        }
        return vacio;
    }

    /**
     * Inicializa la cola
     */
    public Cola(){
        front=null;
        rear=null;
        size=0;
    }

    /**
     * @param element Añade un nuevo elemento al final de la cola
     */
    public void enqueue(int element){
        Nodo nodoNuevo =new Nodo(element);
        if(front==null){
            rear= nodoNuevo;
            front= nodoNuevo;
            size++;
        }else{
            rear.setNext(nodoNuevo);
            rear= nodoNuevo;
            size++;
        }
    }

    /**
     * @return Elimina el primer elemento de la cola y lo devuelve
     */
    public Nodo dequeue(){
        Nodo nodoEliminado = null;
        if(front!=null){
            if(front.getNext()!=null){
                nodoEliminado =new Nodo(front.getData());
                front=front.getNext();
                size--;
            }else{
                nodoEliminado =new Nodo(front.getData());
                front=null;
                rear=null;
                size--;
            }
        }
        return nodoEliminado;
    }

    /**
     * @return Devuelve el primer elemento de la cola sin eliminarlo
     */
    public Nodo peek(){
        Nodo primerNodo = null;
        if(!isEmpty()){
            primerNodo = new Nodo(front.getData());
        }
        return primerNodo;
    }

    /**
     * @return La cantidad de elementos de la cola
     */
    public int getSize() {
        return size;
    }
}