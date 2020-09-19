package prog3.tema00.resueltos.ej00_herencia;

/**
 * Clase que hereda de Documento y representa un PDF
 * @author ekaitz
 */
public class DocumentoWord extends Documento {
	private String texto;

	public DocumentoWord(String titulo, String texto) {
		super(titulo);
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public void validar() {
		System.out.println("El documento word con título " + getTitulo() + " ha sido validado");
	}
	
	
	
	
}
