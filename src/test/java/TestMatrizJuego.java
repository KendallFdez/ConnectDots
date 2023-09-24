import org.junit.jupiter.api.Test;
import server.modelo.MatrizJuego;

public class TestMatrizJuego {
    @Test
    void TestValidarCuadrado() {
        MatrizJuego matrizJuego = new MatrizJuego();
        // Cuadrado 1
        matrizJuego.PonerLineaHorizontal(1, 0, 0);
        matrizJuego.PonerLineaHorizontal(1, 0, 1);
        matrizJuego.PonerLineaVertical(1, 0, 0);
        matrizJuego.PonerLineaVertical(1, 1, 0);

        // Cuadrado 2
        matrizJuego.PonerLineaHorizontal(1, 1, 1);
        matrizJuego.PonerLineaHorizontal(1, 1, 2);
        matrizJuego.PonerLineaVertical(1, 1, 1);
        matrizJuego.PonerLineaVertical(1, 2, 1);

        // Cuadrado 3
        matrizJuego.PonerLineaHorizontal(1, 2, 2);
        matrizJuego.PonerLineaHorizontal(1, 2, 3);
        matrizJuego.PonerLineaVertical(1, 2, 2);
        matrizJuego.PonerLineaVertical(1, 3, 2);

        assert matrizJuego.ValidarCuadros(3).getLength() == 3;
    }
}
