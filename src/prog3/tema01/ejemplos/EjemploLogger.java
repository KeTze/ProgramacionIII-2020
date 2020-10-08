package prog3.tema01.ejemplos;
import java.util.logging.*;

/**Clase de ejemplo de loggers
 */
public class EjemploLogger {

	// Obtener un logger dándole nombre como la clase
	private static Logger logger = Logger.getLogger( EjemploLogger.class.getName() );
	
	// Niveles de importancia para el log:
	// FINEST / FINER / FINE / CONFIG / INFO / WARNING / SEVERE
	// Por defecto se muestran en consola de error solo INFO-WARNING-SEVERE
	
	public static void main(String argv[]) {
		logger.setLevel( Level.ALL );  // Cambiando esto se loggean más o menos mensajes
		//logger.setUseParentHandlers(false);	//Quitamos la consola por defecto
		try {
			// Al logger se le pueden añadir gestores (handler) que además
			// de a la consola de error saquen a fichero, xml, pantalla...
			//La consola por defecto, siempre saca de INFO para arriba
			/*Handler h = new StreamHandler( System.out, new SimpleFormatter() );	
			h.setLevel( Level.INFO );
			logger.addHandler( h );  // Saca todos los errores a out*/
			logger.addHandler( new FileHandler( "EjemploLogger.log.xml") ); // Y también a un xml
			
		} catch (Exception e) {
			logger.log( Level.SEVERE, e.toString(), e );
		}
		logger.log( Level.INFO, "Empezando");
		try{
			for (int j=7; j>=0; j--) {
				logger.log( Level.FINER, "proceso bucle j = {0}", j );
				int i = 1000/j;
				System.out.println( i );
			}
		} catch (Exception ex) {
			// Log un mensaje SEVERE -máxima prioridad-
			logger.log( Level.SEVERE, "error de cálculo", ex );
		}
		logger.info("Se acabó");
	}
}
