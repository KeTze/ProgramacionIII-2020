package prog3.tema00.resueltos.ej00_herencia;

import java.util.ArrayList;

/**
 * Clase para la validación de Documentos y otros objetos que implementen Validacion
 * @author ekaitz
 */
public class Validador {
	private static ArrayList<Validacion> listaDocs = new ArrayList<Validacion>();
	
	public static ArrayList<Validacion> getListaDocs() {
		return listaDocs;
	}
	
	public static void validar() {
		for(Validacion d: listaDocs) {
			d.validar();
		}
	}

	public static void main(String[]args) {
		Documento doc1 = new DocumentoPDF("PruebaPDF", true);
		Documento doc2 = new DocumentoWord("PruebaWord", "adhiu bhaisuhd iuahsdiu haisuh diuahsdiuahsdiu haiudh");
		Video vid1 = new Video();	//podemos añadir cualquier instancia que implemente Validacion
		
		Validador.getListaDocs().add(doc1);
		Validador.getListaDocs().add(doc2);
		Validador.getListaDocs().add(vid1);
		
		Validador.validar();
	}
}
