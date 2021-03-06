package prog3.tema01.ejemplos;

/** Clase de prueba para depurar con Eclipse (Debug = F11)
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class PruebaDebug {

	private static String miMens = "";
	
	private static void mensajeaNumeros(int i) {
		for (int j=0; j<i; j++)
			sacaMens( "Número " + j );
	}
	private static void sacaMens( String mens ) {
		System.out.println( "Mensaje: " + mens + " (longitud " + mens.length() + ")" );
		System.out.println("Hola!");
	}
	public static void main(String[] args) {
		mensajeaNumeros(7);
		miMens = null;
		sacaMens(miMens);
	}

}
