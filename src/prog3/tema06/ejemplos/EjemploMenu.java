package prog3.tema06.ejemplos;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class EjemploMenu {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu Test");
		menuBar.add(menu);
		JMenuItem menuItem = new JMenuItem("Menu 1");
		menu.add(menuItem);
		JMenuItem menuItem2 = new JMenuItem("Menu (Evento)");
		menu.add(menuItem2);
		f.setJMenuBar(menuBar);
		menu.addSeparator();
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		rbMenuItem = new JRadioButtonMenuItem("Another one");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		//También se podría implementar con un ActionListener para todos los botones
		//comprobamos en e.getSource()==menuItem2
		menuItem2.addActionListener(e -> {
			System.out.println(e);
			System.out.println("Pulsado botón 2");
		});
		
		//VentanaBancoDePruebas vent = new VentanaBancoDePruebas( f );
		f.setBounds(0, 0, 400, 200);
		f.setVisible( true );
		//vent.setVisible( true );
	}
}
