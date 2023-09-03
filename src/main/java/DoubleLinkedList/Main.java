package DoubleLinkedList;

public class Main {
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

    }
}
