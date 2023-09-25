import org.junit.jupiter.api.Test;
import server.modelo.MatrizJuego;
import utils.Doble.ListaDoble;
import utils.Doble.NodoDoble;

public class TestMatrizJuego {
    @Test
    void TestValidarCuadrado() {
        MatrizJuego matrizJuego = new MatrizJuego();
        // Cuadrado 1
        matrizJuego.PonerLineaHorizontal(1, 0);
        matrizJuego.PonerLineaHorizontal(1, 6);
        matrizJuego.PonerLineaVertical(1, 0);
        matrizJuego.PonerLineaVertical(1, 1);
        ListaDoble<Integer> resultado0 = matrizJuego.ValidarCuadros(0);

        assert resultado0.getLength() == 1;

        // Cuadrado 2
        matrizJuego.PonerLineaHorizontal(1, 7);
        matrizJuego.PonerLineaHorizontal(1, 13);
        matrizJuego.PonerLineaVertical(1, 8);
        matrizJuego.PonerLineaVertical(1, 9);
        ListaDoble<Integer> resultado1 = matrizJuego.ValidarCuadros(1);

        assert resultado1.getLength() == 1;

        // Cuadrado 3
        matrizJuego.PonerLineaHorizontal(1, 14);
        matrizJuego.PonerLineaHorizontal(1, 20);
        matrizJuego.PonerLineaVertical(1, 16);
        matrizJuego.PonerLineaVertical(1, 17);

        ListaDoble<Integer> resultado2 = matrizJuego.ValidarCuadros(2);


        assert resultado2.getLength() == 1;
        assert matrizJuego.ObtenerUsuarioGanador() == -1;


    }

    @Test
    void TestValidarCuadrado2() {
        MatrizJuego matrizJuego = new MatrizJuego();
        // Cuadrado 1
        matrizJuego.PonerLineaHorizontal(1, 0);
        matrizJuego.PonerLineaHorizontal(1, 6);
        matrizJuego.PonerLineaVertical(1, 0);
        matrizJuego.PonerLineaVertical(1, 1);

        // Cuadrado 2
        matrizJuego.PonerLineaHorizontal(1, 7);
        matrizJuego.PonerLineaHorizontal(1, 13);
        matrizJuego.PonerLineaVertical(1, 8);
        matrizJuego.PonerLineaVertical(1, 9);
        ListaDoble<Integer> resultado1 = matrizJuego.ValidarCuadros(1);

        assert resultado1.getLength() == 2;

        // Cuadrado 3
        matrizJuego.PonerLineaHorizontal(1, 14);
        matrizJuego.PonerLineaHorizontal(1, 20);
        matrizJuego.PonerLineaVertical(1, 16);
        matrizJuego.PonerLineaVertical(1, 17);

        ListaDoble<Integer> resultado2 = matrizJuego.ValidarCuadros(2);


        assert resultado2.getLength() == 1;
        assert matrizJuego.ObtenerUsuarioGanador() == -1;


    }

    @Test
    void TestValidarCuadradoCompleto() {
        MatrizJuego matrizJuego = new MatrizJuego();
        for(int i = 0; i<42; i++)
        {
            matrizJuego.PonerLineaHorizontal(1, i);
            matrizJuego.PonerLineaVertical(1, i);
        }

        ListaDoble<Integer> resultado = matrizJuego.ValidarCuadros(3);
        NodoDoble<Integer> head = resultado.getHead();
        for(int i = 0; i<36; i++)
        {
            int data = head.getData();
            boolean valor = data == i;
            head.getNext();
        }
        assert resultado.getLength() == 36;
        assert matrizJuego.ObtenerUsuarioGanador() == 3;



    }
}
