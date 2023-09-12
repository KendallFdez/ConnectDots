package Server;

import Client.interfaz.Controller;
import Server.Cola.Cola;
import Server.Doble.ListaDoble;
import javafx.scene.control.Button;

public class probarColaLista {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble<String>();
        lista.insertFirst("Kendall1");
        lista.insertFirst("Kendall2");
        lista.insertFirst("Kendall3");
        lista.insertFirst("Kendal4");
        lista.insertFirst("Kendall5");
        lista.insertFirst("Kendall6");
        lista.insertFirst("Kendall7");
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
        Controller controller = new Controller();
        controller.largoMatriz();
    }
}
