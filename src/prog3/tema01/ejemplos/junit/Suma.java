package prog3.tema01.ejemplos.junit;

public class Suma {
    public int getSuma(int a, int b) {
        // Se multiplica en vez de sumar a posta, para que los test fallen
        return a * b;
    }

    public int incrementa(int a) {
        return a + 1;
    }
}