package Server;

import Server.Cola.Cola;
import Server.Doble.ListaDoble;

public class probarColaLista {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        lista.insertLast(1);
        lista.insertLast(10);
        lista.insertLast(15);
        lista.insertLast(20);
        lista.insertLast(30);
        lista.insertLast(40);
        lista.insertFirst(0);
        lista.deleteFirst();
        lista.deleteLast();
        lista.displayForward();
        int[] a = new int[8];
        Cola micola=new Cola();
        micola.enqueue(10);
        System.out.println(micola.getSize());
        System.out.println(micola.peek().getData()+" es el elemento del frente");
        micola.enqueue(20);
        micola.enqueue(30);
        micola.enqueue(40);
        System.out.println(micola.dequeue().getData()+" se elimino de la cola");
        System.out.println("El tamaño de la cola es "+micola.getSize());
    }
}
