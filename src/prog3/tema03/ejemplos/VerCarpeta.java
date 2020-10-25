package prog3.tema03.ejemplos;

import java.io.File;

public class VerCarpeta {

	public static void main(String[] args) {
		File file = new File( "d:/workspace" );
		System.out.println( file.getName() );
		visualizar2( file );
	}
	
	// pre file es un directorio
	// visualizar los ficheros y carpetas de nivel 2
	private static void visualizar2( File file ) {
		for (File f2 : file.listFiles()) {
			if (f2.isFile()) {
				System.out.println( "  (F) " + f2.getName() );
			} else {
				System.out.println( "  (D) " + f2.getName() );
				visualizar3( f2 );
			}
		}
	}
	
	// pre file es carpeta
	private static void visualizar3( File file ) {
		for (File f2 : file.listFiles()) {
			if (f2.isFile()) {
				System.out.println( "    (F) " + f2.getName() );
			} else {
				System.out.println( "    (D) " + f2.getName() );
			}
		}
	}

}
