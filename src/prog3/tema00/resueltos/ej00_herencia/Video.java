package prog3.tema00.resueltos.ej00_herencia;

public class Video implements Validacion{
	private String contenido;

	@Override
	public void validar() {
		System.out.println("se ha validado el video");
	}
	
	
}
