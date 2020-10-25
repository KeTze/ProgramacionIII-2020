package prog3.tema01.ejemplos;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SendMail {
	public static void main(String[] args) {
		final String fromEmail = "prog3@epolledo.com"; //requires valid gmail id
		final String password = "Prog_3@mail"; // correct password for gmail id
		final String toEmail = "epolledo@deusto.es"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "epolledo.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EjemploMail.sendEmail(session, toEmail,"[PROG3] Correo ejemplo", "Esto es un correo de prueba.");
		
	}
}
