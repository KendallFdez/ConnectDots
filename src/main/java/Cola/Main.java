package Cola;

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
    }
}
