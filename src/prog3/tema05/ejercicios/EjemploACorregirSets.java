package prog3.tema05.ejercicios;

import java.util.*;

public class EjemploACorregirSets {
	static HashSet<Fantasma> hS;
	static TreeSet<Fantasma> hSS;
	public static void main(String[] args) {
		hS = new HashSet<>();
		hS.add( new Fantasma( "casper", 1, 2) );
		hS.add( new Fantasma( "opera phantom", 4, 2) );
		hS.add( new Fantasma( "casper", 1, 2) );
		hS.add( new Fantasma( "myrtle", 5, 10) );
		Iterator it = hS.iterator();
		while(it.hasNext()) {
			Fantasma f = (Fantasma) it.next();
			System.out.println(f);
		}
		System.out.println( hS );  // ¿Por qué añade dos veces a casper?
		hSS = new TreeSet<>();
		hSS.add( new Fantasma( "casper", 1, 2) );
		hSS.add( new Fantasma( "opera phantom", 4, 2) );
		hSS.add( new Fantasma( "casper", 1, 2) );
		hSS.add( new Fantasma( "myrtle", 5, 10) );
		System.out.println( hSS ); // ¿Por qué da error en ejecución?
	}
	
	private static class Fantasma implements Comparable {
		String nombre;
		int x;
		int y;
		public Fantasma(String nombre, int x, int y) {
			super();
			this.nombre = nombre;
			this.x = x;
			this.y = y;
		}	
		@Override
		public String toString() {
			return nombre + " (" + x + "," + y + ")";
		}
		
		@Override
		public int hashCode() {
			/*int result = nombre.hashCode();
	        result = 31 * result + x;
	        result = 31 * result + y;
			 * */
			return Objects.hash(nombre, x, y);
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Fantasma c = (Fantasma) obj;
			if(nombre.equals(c.nombre) && x == c.x && y == c.y) return true;
			else return false;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return nombre.compareTo(((Fantasma)o).nombre);
			
			/*
			Fantasma c = (Fantasma) o;
			if(y > c.y) return 1;
			else if(y < c.y) return -1;
			else return 0;
			*/
		}
	}
	
}
