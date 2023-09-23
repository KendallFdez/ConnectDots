import org.junit.jupiter.api.Test;
import server.modelo.Juego;

public class TestJuego {
    @Test
    void TestValidarCuadrado() {
        Juego juego = new Juego();
        // Cuadrado 1
        juego.PonerLineaHorizontal(1, 0, 0);
        juego.PonerLineaHorizontal(1, 0, 1);
        juego.PonerLineaVertical(1, 0, 0);
        juego.PonerLineaVertical(1, 1, 0);

        // Cuadrado 2
        juego.PonerLineaHorizontal(1, 1, 1);
        juego.PonerLineaHorizontal(1, 1, 2);
        juego.PonerLineaVertical(1, 1, 1);
        juego.PonerLineaVertical(1, 2, 1);

        // Cuadrado 3
        juego.PonerLineaHorizontal(1, 2, 2);
        juego.PonerLineaHorizontal(1, 2, 3);
        juego.PonerLineaVertical(1, 2, 2);
        juego.PonerLineaVertical(1, 3, 2);

        assert juego.ValidarCuadros(3).getLength() == 3;
    }
}
