package utils;
import utils.Cola.Cola;
import utils.Doble.ListaDoble;

public class Main {
    public static void main(String[] args) {
        // Crea una nueva cola vacía
        Cola<Integer> micola = new Cola<>();
        // Añade el número 10 a la cola
        micola.enqueue(10);
        // Imprime el tamaño de la cola
        System.out.println(micola.getSize());
        // Imprime el primer elemento de la cola
        System.out.println(micola.peek().getData() + " es el elemento del frente");
        // Añade los números 20, 30 y 40 a la cola
        micola.enqueue(20);
        micola.enqueue(30);
        micola.enqueue(40);
        // Elimina el primer elemento de la cola y lo imprime
        System.out.println(micola.dequeue().getData() + " se eliminó de la cola");
        // Imprime el tamaño de la cola después de eliminar el primer elemento
        System.out.println("El tamaño de la cola es " + micola.getSize());

        // Crea una nueva lista doble vacía
        ListaDoble<Integer> lista = new ListaDoble<>();
        // Añade los números 1, 10, 15, 20, 30 y 40 a la lista
        lista.insertLast(1);
        lista.insertLast(10);
        lista.insertLast(15);
        lista.insertLast(20);
        lista.insertLast(30);
        lista.insertLast(40);
        // Añade el número 0 al principio de la lista
        lista.insertFirst(0);
        // Elimina el primer elemento de la lista
        lista.deleteFirst();
        // Elimina el último elemento de la lista
        lista.deleteLast();
        // Imprime la lista en orden
        lista.displayForward();
        // Crea un nuevo array de enteros de tamaño 8
        int[] a = new int[8];
    }
}
