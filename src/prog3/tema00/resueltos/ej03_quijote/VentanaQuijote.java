package prog3.tema00.resueltos.ej03_quijote;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

/** Ejercicio de hilos  con ventanas. Esta clase carga el texto del Quijote en un área de texto,
 * y permite navegar por el área con la scrollbar y con botones de página arriba y página abajo.
 * 1. Modificarlo para que al pulsar los botones el scroll se haga con una animación 
 * a lo largo de un segundo, en lugar de en forma inmediata.
 */
public class VentanaQuijote extends JFrame {

	private JTextArea taTexto;
	private JScrollPane spTexto;
	
	public VentanaQuijote() {
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
	}
	
	private void muevePagina( int pixelsVertical ) {
		JScrollBar bVertical = spTexto.getVerticalScrollBar();
		System.out.println( "Moviendo texto de " + bVertical.getValue() + " a " + (bVertical.getValue()+pixelsVertical) );
		Thread t = new Thread() {
			public void run() {
				//Dividimos los pixeles en grupos para que el proceso dure aprox. 1 segundo
				int pixelsVerticalMin = Math.abs(pixelsVertical)/100;
				if (pixelsVertical>0) {	//Si vamos hacia abajo
					for (int i=0; i<pixelsVertical; i+= pixelsVerticalMin) {
						bVertical.setValue( bVertical.getValue() + pixelsVerticalMin );
						try {Thread.sleep(10); } catch (InterruptedException e) {}
					}
				} else { //Si vamos hacia arriba
					for (int i=0; i<Math.abs(pixelsVertical); i+= pixelsVerticalMin) {
						bVertical.setValue( bVertical.getValue() - pixelsVerticalMin );
						try {Thread.sleep(10); } catch (InterruptedException e) {}
					}
				}
			}
		};
		t.start();
	}
	
	private void cargaQuijote() {
		try {
			Scanner scanner = new Scanner( VentanaQuijote.class.getResourceAsStream( "DonQuijote.txt" ), "UTF-8" );
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
		VentanaQuijote v = new VentanaQuijote();
		v.setVisible( true );
		v.cargaQuijote();
	}

}