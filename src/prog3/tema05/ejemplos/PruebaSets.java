package prog3.tema05.ejemplos;

import java.util.*;

public class PruebaSets {
	static HashSet<Punto> hS;
	static HashSet<String> hSS;
	public static void main(String[] args) {
		hS = new HashSet<>();
		hS.add( new Punto(1,2) );
		hS.add( new Punto(2,3) );
		hS.add( new Punto(2,3) );
		hS.add( new Punto(3,2) );
		System.out.println( hS );
		hSS = new HashSet<>();
		hSS.add( "Andoni" );
		hSS.add( "Marta" );
		hSS.add( "Emilio" );
		hSS.add( "Marta" );
		hSS.add( "a1" );
		hSS.add( "a2" );
		System.out.println( hSS );
		Iterator it = hSS.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class Punto {
	int x;
	int y;
	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
/* Probar a comentar estos dos métodos y ver lo que pasa. ¿Por qué? */
	
	@Override
	public int hashCode() {
		//return x + y;
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Punto)) return false;
		Punto p2 = (Punto) obj;
		return x==p2.x && y==p2.y;
	}
	
}
