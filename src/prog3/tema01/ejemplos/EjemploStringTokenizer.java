package prog3.tema01.ejemplos;

import java.util.StringTokenizer;

public class EjemploStringTokenizer {
	public static void main(String[] args) {
		String prueba = "Esto es una frase con palabras "+
				"separadas por \"espacios\". " +
				"También por puntos, y por comas.";
		StringTokenizer st = new StringTokenizer( prueba, " .," );
		while (st.hasMoreTokens()) {
			System.out.println( st.nextToken() );
		}
	}
}
