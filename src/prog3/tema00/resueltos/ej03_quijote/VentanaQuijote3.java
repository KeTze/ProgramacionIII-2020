package prog3.tema00.resueltos.ej03_quijote;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

//Versión 3.
//Incorporar cierre de hilos cuando se cierra la ventana
//(Opciones: daemon, variable lógica, interrupt())
public class VentanaQuijote3 extends JFrame {

	private JTextArea taTexto;
	private JScrollPane spTexto;
	
	public VentanaQuijote3() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Don Quijote de la Mancha" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );  // Pone la ventana relativa a la pantalla
		taTexto = new JTextArea();
		spTexto = new JScrollPane( taTexto );
		add( spTexto, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPagArriba = new JButton( "^" );
		JButton bPagAbajo = new JButton( "v" );
		pBotonera.add( bPagArriba );
		pBotonera.add( bPagAbajo );
		add( pBotonera, BorderLayout.SOUTH );
		bPagArriba.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( -(spTexto.getHeight()-20) );
			}
		});
		bPagAbajo.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( (spTexto.getHeight()-20) );
			}
		});
		//Al cerrar la ventana lanzamos la interrupción
		addWindowListener(new WindowAdapter(){
			public void windowClosed(WindowEvent e) {
				for (Thread t : hilosActivos) {
					t.interrupt();
				}
			}
		});
	}

	private ArrayList<Thread> hilosActivos = new ArrayList<>();
	
	private void muevePagina( int pixelsVertical ) {
		Thread hiloActual = new Thread() {  // ...porque solo lo usamos aquí
			public void run() {
				// Thread yo = hiloActual;  // En vez de guardar el hilo para cogerlo en la variable
				Thread yo = this;  // ... lo podemos tomar directamente del this
				hilosActivos.add( yo );
				//MODO 1
				while (hilosActivos.get(0) != yo) {
					if (interrupted()) return; // Comprobamos si ha habido una interrupción para parar el hilo
					System.out.println( "Soy " + yo.getName() + " y la cola es " + hilosActivos );
					try {
						Thread.sleep( 10 );
					} catch (InterruptedException e) {
						return;	// Parar el hilo con interrupción
					}
				}
				//MODO 2
				/*if(hilosActivos.get(0) != yo) {
					try {
						synchronized (this){
							wait();
						}
					} catch (InterruptedException e) {
						return;	// Parar el hilo con interrupción
					}
				}*/
				
				
				JScrollBar bVertical = spTexto.getVerticalScrollBar();
				System.out.println( "Moviendo texto de " + bVertical.getValue() + " a " + (bVertical.getValue()+pixelsVertical) );
				// bVertical.setValue( bVertical.getValue() + pixelsVertical );
				int pixelsVerticalMin = Math.abs(pixelsVertical)/100;
				if (pixelsVertical>0) {
					for (int i=0; i<pixelsVertical; i+= pixelsVerticalMin) {
						if (interrupted()) return; // Parar el hilo con interrupción
						bVertical.setValue( bVertical.getValue() + pixelsVerticalMin );
						try {Thread.sleep(10); } catch (InterruptedException e) {
							return;	// Parar el hilo con interrupción
						}
					}
				} else {
					for (int i=0; i<Math.abs(pixelsVertical); i+= pixelsVerticalMin) {
						if (interrupted()) return; // Parar el hilo con interrupción
						bVertical.setValue( bVertical.getValue() - pixelsVerticalMin );
						try {Thread.sleep(10); } catch (InterruptedException e) {
							return;	// Parar el hilo con interrupción
						}
					}
				}
				hilosActivos.remove(0);
				
				//MODO 2: Si usamos este modo, notificar al siguiente hilo para que siga adelante. 
				/*if(hilosActivos.size() > 0) {
					synchronized (hilosActivos.get(0)){
						hilosActivos.get(0).notify();
					}
				}*/
				
			}
		};

		//hiloActual.setDaemon(true);	//Parar el hilo con daemon - NO LO PARA AL INSTANTE
		hiloActual.start();
	}
	
	private void cargaQuijote() {
		try {
			Scanner scanner = new Scanner( VentanaQuijote3.class.getResourceAsStream( "DonQuijote.txt" ), "UTF-8" );
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				taTexto.append( linea + "\n" );
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "No se ha podido cargar el texto" );
		}
	}

	public static void main(String[] args) {
		VentanaQuijote3 v = new VentanaQuijote3();
		v.setVisible( true );
		v.cargaQuijote();
	}

}