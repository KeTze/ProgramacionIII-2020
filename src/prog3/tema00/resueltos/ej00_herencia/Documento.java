package prog3.tema00.resueltos.ej00_herencia;

/**
 * Clase padre Documento
 * @author ekaitz
 */
public abstract class Documento implements Validacion {
	private String titulo;

	public Documento(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Método abstracto a implementar en las clases hija
	 */
	public abstract void validar();
	
}
