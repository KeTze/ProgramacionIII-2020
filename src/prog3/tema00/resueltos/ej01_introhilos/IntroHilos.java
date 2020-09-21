package prog3.tema00.resueltos.ej01_introhilos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class IntroHilos
{
	private static boolean proceso = true;
	//Declaramos los componentes label fuera para poder acceder a ellos desde la clase interna.
	private static JLabel lblContador;
	private static JLabel lblDecreciente;
	/*
	 * Ejercicio para introducirnos a los hilos. Al ser sencillo podemos hacer todo en el main.
	 * */
	public static void main(String[] args)
	{
		// Se pueden crear ventanas directamente desde las clases de Swing (aunque es deseable cuando son un poco elaboradas hacerlas con clases nuevas que extiendan JFrame)
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		ventana.setTitle( "Contador" );
		ventana.setSize( 100, 100 );
		
		//Creamos los componentes
		lblContador = new JLabel("");
		lblDecreciente = new JLabel("");
		JButton btnStop = new JButton("STOP");
		//Listener para parar el hilo del contador
		btnStop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				proceso = false;
			}
		});
		//Añadimos los componentes al layout del JFrame
		ventana.add(lblContador, BorderLayout.CENTER);
		ventana.add(lblDecreciente, BorderLayout.NORTH);
		ventana.add(btnStop, BorderLayout.SOUTH);
		ventana.setVisible(true);
		
		//Forma 1 de crear un hilo. Declarándolo con una clase anónima
		Thread t = new Thread(new Runnable(){ // Clase anónima heredada de Thread para crear el hilo. 
			int i = 0;
			public void run() {  // Método principal que debe tener todo hilo - es como el main para cada hilo
				while(proceso){	//Mientras que proceso sea true, se sigue.
					System.out.println("A = " + i);
					lblContador.setText(i+"");
					i++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		//Forma 2 de crear un hilo. Declarando una clase interna.
		Thread t2 = new MiHilo();
		
		//Indicamos que los hilos deben pararse si se cierran las ventanas, sino seguirían infinitamente.
		t.setDaemon( true );
		t2.setDaemon( true );
		//Lanzamos los dos hilos
		t.start();
		t2.start();
	}
	
	static class MiHilo extends Thread {
		int i = 20;
		public void run() {
			while(i >= 0 && proceso){
				System.out.println("B = " + i);
				lblDecreciente.setText(i+"");
				i--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
