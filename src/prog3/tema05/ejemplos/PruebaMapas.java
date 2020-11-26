package prog3.tema05.ejemplos;

import java.util.HashMap;
import java.util.TreeMap;

public class PruebaMapas {
	public static void main(String[]args) {
		HashMap<String, Datos> hDatos = new HashMap<>();
		hDatos.put("11111111A", new Datos("11111111A", "Ekaitz", "Polledo"));
		hDatos.put("33333333C", new Datos("33333333C", "Persona3", "Apellido3"));
		hDatos.put("22222222B", new Datos("22222222B", "Persona2", "Apellido2"));
		
		System.out.println(hDatos);
		
		TreeMap<String, Datos> tDatos = new TreeMap<>();
		tDatos.put("11111111A", new Datos("11111111A", "Ekaitz", "Polledo"));
		tDatos.put("33333333C", new Datos("33333333C", "Persona3", "Apellido3"));
		tDatos.put("22222222B", new Datos("22222222B", "Persona2", "Apellido2"));
		
		System.out.println(tDatos);
	}
}


class Datos {
	String dni;
	String nombre;
	String apellido;
	public Datos(String dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}	
	@Override
	public String toString() {
		return dni + " - " + nombre + " " + apellido;
	}
	
}