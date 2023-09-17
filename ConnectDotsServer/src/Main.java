<<<<<<< Updated upstream:ConnectDotsServer/src/Main.java
import Server.MiServidor;
import Server.Recepcion;
import Utils.Cola.Cola;
import Utils.DoubleLinkedList.ListaDoble;
=======
package Server;
import Server.Cola.Cola;
import Server.Doble.ListaDoble;
import Server.socket.Recepcion;
import Server.socket.Repartidor;
>>>>>>> Stashed changes:src/main/java/Server/Main.java

public class Main {
    public static void main(String[] args) {
        Cola micola=new Cola();
        micola.enqueue(10);
        System.out.println(micola.getSize());
        System.out.println(micola.peek().getData()+" es el elemento del frente");
        micola.enqueue(20);
        micola.enqueue(30);
        micola.enqueue(40);
        System.out.println(micola.dequeue().getData()+" se elimino de la cola");
        System.out.println("El tamaño de la cola es "+micola.getSize());

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


        Repartidor repartidor = new Repartidor();
        Recepcion recepcion=new Recepcion(repartidor);

        Thread mihilo2= new Thread(repartidor);

        mihilo2.start();

        Thread mihilo= new Thread(recepcion);

        mihilo.start();
    }
}