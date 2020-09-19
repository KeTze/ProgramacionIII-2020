package prog3.tema00.resueltos.ej00_herencia;

/**
 * Clase que hereda de Documento y representa un PDF
 * @author ekaitz
 */
public class DocumentoPDF extends Documento {
	private boolean editable;
	
	public DocumentoPDF(String titulo, boolean editable) {
		super(titulo);	//Asignamos la variable titulo de la clase padre
		this.editable = editable;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public void validar() {
		System.out.println("El documento pdf con título " + getTitulo() + " ha sido validado");
	}
}
