package prog3.tema00.resueltos.ej02_ventanashilos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class VentanaConfirmacionLenta {

	private static Random r = new Random();
	
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) {
		MiVentana ventana = new MiVentana();	//Creamos una nueva ventana
		ventana.setVisible(true);	//Lanzamos la ventana y el hilo de swing.
	}
	
	/*
	 * En la anterior práctica habíamos creado la ventana en el main directamente. 
	 * Ahora lo haremos con una clase interna. Más recomendable cuando sea más compleja.
	 */
	static class MiVentana extends JFrame {
		private JTextArea taTexto;
		private JButton btnConfirmar;
		
		MiVentana() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Indicamos a la ventana que libere el hilo al cerrarse 
			setSize( 200, 300 );
			//Creamos la textarea (Declarada como atributo de clase para poder acceder a ella desde el listener)
			taTexto = new JTextArea();
			
			//Creamos un JPanel para poder insertar dos componentes en el centro del layout principal
			JPanel pCentral = new JPanel();
			pCentral.setLayout(new BorderLayout());	//Por defecto, FlowLayout. Lo cambiamos a BorderLayout.
			pCentral.add(taTexto, BorderLayout.CENTER);	//Añadimos el textarea al centro del panel.
			
			JProgressBar pBar = new JProgressBar(0, 10);	//Barra de progreso que indica los caracteres que nos faltan. Le indicamos que los valores estarán entre 0 y 10.
			pBar.setValue(0);	//Por defecto estará a 0
			pCentral.add(pBar, BorderLayout.SOUTH);
			add(pCentral, BorderLayout.CENTER);	//Añadimos el panel al componente principal de la ventana
			
			//Añadimos un listener para lanzar un evento cada vez que se pulse una tecla.
			taTexto.addKeyListener(new KeyListener(){
				public void keyReleased(KeyEvent e) {
					System.out.println(taTexto.getText().length());
					pBar.setValue(taTexto.getText().length());	//Actualizamos la barra de progreso.
					if(taTexto.getText().length() > 10){	//Si es >10, quitamos el texto sobrante.
						String text = taTexto.getText().substring(0,  10);
						taTexto.setText(text);
					}
				}
				public void keyTyped(KeyEvent e) {
				}
				public void keyPressed(KeyEvent e) {
				}
			});
			
			
			//Creamos el botón de confirmación y lo colocamos en la posición sur del layout
			btnConfirmar = new JButton("Confirmar");
			add(btnConfirmar, BorderLayout.SOUTH);
			
			//Listener que lanza un hilo para que no se bloquee el botón. Además lo deshabilita mientras se hace el proceso.
			btnConfirmar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(new Runnable(){
						@Override
						public void run() {
							btnConfirmar.setEnabled(false);
							procesoConfirmar();
							btnConfirmar.setEnabled(true);
						}
					});
					t.start();
				}
			});
		}
	}

}
