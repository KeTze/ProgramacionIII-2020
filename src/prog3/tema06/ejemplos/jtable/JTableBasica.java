package prog3.tema06.ejemplos.jtable;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class JTableBasica extends JFrame{
	
	public JTableBasica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 600, 250 );
		//DefaultTableModel modelTabla = new DefaultTableModel();
		MiModelo modelTabla = new MiModelo();
		JTable tabla = new JTable(modelTabla);
		//tabla.setModel(modelTabla); // -> Se puede hacer también así
		
		modelTabla.addColumn("columna 1");
		modelTabla.addColumn("columna 2");
		modelTabla.addColumn("columna 3");
		
		Object [] fila = new Object[3];
		fila[0] = "dato columna 1";
		fila[1] = 2;
		fila[2] = true;
		modelTabla.addRow ( fila ); // Añade una fila al final
		modelTabla.setValueAt (4, 0, 1); // Cambia el valor de la fila 0, columna 1.
		modelTabla.addRow ( fila ); // Añade una fila al final
		//modelTabla.removeRow (0); // Borra la primera fila
		
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.rowAtPoint(e.getPoint());
				int columna = tabla.columnAtPoint(e.getPoint());
				if ((fila > -1) && (columna > -1))
					System.out.println(modelTabla.getValueAt(fila,columna));
			}
		});
		
		modelTabla.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				System.out.println("MODELO CAMBIADO!!");
			}
		});
		
		add(new JScrollPane(tabla), BorderLayout.CENTER);
		setVisible(true);
	}
	
	
	
	
	
	public class MiModelo extends DefaultTableModel
	{
	   public boolean isCellEditable (int row, int column)
	   {
	       // Aquí devolvemos true o false según queramos que una celda
	       // identificada por fila,columna (row,column), sea o no editable
	       if (column == 1)
	          return true;
	       return false;
	   }
	   /** Tercera columna Boolean, segunda Integer y el resto Object */
	   public Class getColumnClass(int columna)
	   {
	      if (columna == 2) return Boolean.class;	//Curiosidad: Nos lo cambia por un JCheckBox
	      if (columna == 1) return Integer.class;
	      return Object.class;
	   }
	}
	
	public static void main (String[]args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTableBasica();
            }
        });
	}
}
