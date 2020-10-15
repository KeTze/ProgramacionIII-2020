package prog3.tema01.ejemplos.objects_sockets;

import java.io.Serializable;

public class Message implements Serializable{
	 private final String text;

	 public Message(String text) {
	     this.text = text;
	 }

	 public String getText() {
	     return text;
	 }
}