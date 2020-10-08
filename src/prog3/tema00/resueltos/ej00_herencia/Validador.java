package prog3.tema00.resueltos.ej00_herencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * Clase para la validación de Documentos y otros objetos que implementen Validacion
 * @author ekaitz
 */
public class Validador {
	static Logger logger;
	
	private static ArrayList<Validacion> listaDocs = new ArrayList<Validacion>();
	
	public static ArrayList<Validacion> getListaDocs() {
		return listaDocs;
	}
	
	public static void validar() {
		for(Validacion d: listaDocs) {
			logger.log(Level.FINEST, "Validar()");
			d.validar();
		}
	}

	public static void main(String[]args) {
		logger = Logger.getLogger("prueba-logger");
		logger.setLevel(Level.ALL);
		
		//logger.setUseParentHandlers(false);
		
		try {
			Handler h = new FileHandler("log.xml");
			logger.addHandler(h);
			h.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
		}
		
		logger.log(Level.INFO, "Inicio Validador()");
		
		Documento doc1 = new DocumentoPDF("PruebaPDF", true);
		Documento doc2 = new DocumentoWord("PruebaWord", "adhiu bhaisuhd iuahsdiu haisuh diuahsdiuahsdiu haiudh");
		Video vid1 = new Video();	//podemos añadir cualquier instancia que implemente Validacion
		
		getListaDocs().add(doc1);
		getListaDocs().add(doc2);
		getListaDocs().add(vid1);
		
		validar();
		
		String ejemplo = null;
		try{
			System.out.println(ejemplo.length());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error grave", "ERROR", JOptionPane.ERROR_MESSAGE);
			logger.log(Level.SEVERE, "Error: Nullpointer", e);
		}
		
		logger.log(Level.INFO, "Fin Validador()");
	}
}
