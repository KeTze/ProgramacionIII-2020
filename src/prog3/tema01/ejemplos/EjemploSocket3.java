package prog3.tema01.ejemplos;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class EjemploSocket3 {

	private static void lanzaCliente(){
		try {
			Socket socket = new Socket("localhost", 4000);
			DataOutputStream dOutput = new DataOutputStream(socket.getOutputStream());
			int contador = 0;
			while(true) {
				dOutput.writeBytes("Contador: " + contador);
				dOutput.writeByte('\n');
				Thread.sleep(2000);
				contador++;
			}
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void lanzaServidor(){
		try {
			ServerSocket s = new ServerSocket(4000);
			Socket socket = s.accept();
			
			BufferedReader dInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				System.out.println("Servidor");
				String texto = dInput.readLine();
				System.out.println(texto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) {
		Thread tServidor = new Thread(
				() -> { lanzaServidor(); }
		);
		Thread tCliente = new Thread(
				() -> { lanzaCliente(); }
		);
		//tServidor.start();
		//tCliente.start();
		
		InetAddress iAdd = null;
		try {
			iAdd = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println(iAdd.getHostAddress());
		System.out.println(iAdd.getHostName());
		
		InetAddress iAdd2 = null;
		try {
			iAdd2 = InetAddress.getByName("www.deusto.es");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println(iAdd2.getHostAddress());
		System.out.println(iAdd2.getHostName());
	}
}
