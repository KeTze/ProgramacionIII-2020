package prog3.tema03.ejemplos;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class EjemploProperties1 {
	public static void main(String[]args) {
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("test.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("uno=" + p.getProperty("uno"));
		
		System.out.println("cuatro=" + p.getProperty("cuatro", "default value"));
		
		Enumeration<Object> keys = p.keys();
		while(keys.hasMoreElements()) {
			Object key = keys.nextElement();
			System.out.println(key + " = " + p.get(key));
		}
		
		//ESCRITURA
		
		p.setProperty("cuatro", "4");
		
		try {
			p.store(new FileWriter("test.properties"), "Un comentario");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
