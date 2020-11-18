package prog3.tema04.ejemplos;

public class RecursividadEjemplos {
	public static void main(String[]args) {
		//f(100);
		/*factorial(14, 0, 1);
		factorial2(14, 1);
		System.out.println("Valor: " + factorial3(14));*/
		//System.out.println(fib(4));
		
		/*int [] v = {1, 2, 10, 11, 15, 17, 21, 43, 57, 83, 84, 85, 86, 87, 89, 110 };
		int donde = busquedaBinaria(v, 12);
		System.out.println("Posicion: " + donde);*/
		
		hanoi(3, 'a', 'c', 'b');
	}
	
	public static void f(int valor) {
		if(valor >=0) {
			f(valor-1);
			System.out.println("Valor: " + valor);
		}
	}
	
	public static void factorial(int objetivo, int num, int valor) {
		if(objetivo == num) {
			System.out.println("Valor:" + valor);
		} else {
			int siguiente = (num+1) * valor;
			factorial(objetivo, num+1, siguiente);
		}
	}
	public static void factorial2(int objetivo, int valor) {
		if(objetivo == 0){
			System.out.println("Valor:" + valor);
		} else {
			int siguiente = objetivo * valor;
			factorial2(objetivo-1, siguiente);
		}
	}
	public static int factorial3(int n) {
		if(n == 0) {
			return 1;
		} else {
			return n * factorial3(n-1);
		}
	}
	
	public static long fib (int n){
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else return fib(n-1)+fib(n-2);
	}
	
	// ----- BUSQUEDA BINARIA -----
	
	public static int busquedaBinaria(int[] v, int valorBuscado){
		return busq(v, valorBuscado, 0, v.length-1);
	}
	
	public static int busq (int[] v, int valorBuscado, int ini, int fin) {
		if(ini>fin) {
			return -1;
		} else {
			int mitad = (ini+fin)/2;
			if(v[mitad] == valorBuscado){
				return mitad;
			} else if(v[mitad] < valorBuscado){
				return busq(v, valorBuscado, mitad+1, fin);
			} else {
				return busq(v, valorBuscado, ini, mitad-1);
			}
		}
	}
	
	// HANOI
	
	public static void hanoi(int n, char origen, char destino, char auxiliar) {
		if(n == 1){
			System.out.println("Mover 1 de " + origen + " a " + destino);
		} else {
			hanoi(n-1, origen, auxiliar, destino);
			System.out.println("Mover " + n + " de " + origen + " a " + destino);
			hanoi(n-1, auxiliar, destino, origen);
		}
	}
}
