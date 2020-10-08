package prog3.tema01.ejemplos;

import java.util.regex.Pattern;

public class EjemploPattern {
	private static String[] testNombres = {
		"prueba.txt", "prueba2.jpg", "otro.dat", "pedro.doc", "andoni.txt", "dir"
	};
	public static void main(String[] args) {
		// Expresión regular de p*.* -->   p .* \. .*
		// Como el carácter \ en un string en Java es especial, hay que poner \\
		String patron1 = "pr.*\\..*";   // Patrón de la ER  String "p.*\\..*" -> ER p.*\..* 
		System.out.println( patron1 );
		Pattern pat1 = Pattern.compile( patron1 );  // Se compila
		for (String s : testNombres) {
			if (pat1.matcher(s).matches())  // Se saca un "emparejador" y se comprueba si casa
				System.out.println( s + " cumple el patrón " + patron1 );
			else 
				System.out.println( "   " + s + " no cumple el patrón " + patron1 );
		}
		String patronEmail = ".*@.*\\.[a-z]*";
		
		Pattern pat2 = Pattern.compile( patronEmail );  // Se compila
		if (pat2.matcher("email@email.com").matches())  // Se saca un "emparejador" y se comprueba si casa
			System.out.println( "Email correcto" );
		else 
			System.out.println( "Email incorrecto" );
		
		String patronTelefono = "\\d{9}";
		
		Pattern pat3 = Pattern.compile( patronTelefono );  // Se compila
		if (pat3.matcher("666555446").matches())  // Se saca un "emparejador" y se comprueba si casa
			System.out.println( "Telefono correcto" );
		else 
			System.out.println( "Telefono incorrecto" );
		
		String patronFecha = "\\d{2}/\\d{2}/\\d{4}";
		
		Pattern pat4 = Pattern.compile( patronFecha );  // Se compila
		if (pat4.matcher("01/01/2000").matches())  // Se saca un "emparejador" y se comprueba si casa
			System.out.println( "Fecha correcto" );
		else 
			System.out.println( "Fecha incorrecto" );
		
	}
}
