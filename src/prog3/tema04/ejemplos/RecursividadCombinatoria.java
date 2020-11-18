package prog3.tema04.ejemplos;

public class RecursividadCombinatoria {
	public static void main(String[]args) {
		comb3(5, new char[] {'a', 'b', 'c', 'd'}, "");
		//comb2(3, "");
		//comb1(2, "");
	}
	
	public static void comb3(int n, char[] cars, String combinacion) {
		if(n == 0) {
			System.out.println(combinacion);
		} else {
			for(char c: cars) {
				comb3(n-1, cars, combinacion + c);
			}
		}
	}
	
	public static void comb2(int n, String combinacion) {
		if(n == 0) {
			System.out.println(combinacion);
		} else {
			comb2(n-1, combinacion + "A");
			comb2(n-1, combinacion + "B");
			comb2(n-1, combinacion + "C");
		}
	}
	
	public static void comb1(int n, String combinacion) {
		if(n == 0) {
			System.out.println(combinacion);
		} else {
			comb1(n-1, combinacion + "A");
			comb1(n-1, combinacion + "B");
		}
	}
}
