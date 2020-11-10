package prog3.tema04.ejemplos;

public class RecursividadEjemplos {
	public static void main(String[]args) {
		f(100);
		/*factorial(14, 0, 1);
		factorial2(14, 1);
		System.out.println("Valor: " + factorial3(14));*/
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
}
