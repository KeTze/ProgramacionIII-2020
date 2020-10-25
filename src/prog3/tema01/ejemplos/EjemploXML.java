package prog3.tema01.ejemplos;

import java.io.File;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//Error dtd: https://docs.oracle.com/en/java/javase/14/core/java-logging-overview.html

public class EjemploXML {
	public static void main(String[]args) {
		try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
 
            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("EjemploLogger.log.xml"));
 
            // Cojo todas las etiquetas del documento
            NodeList listaLogs = documento.getElementsByTagName("record");
            
            // Recorro las etiquetas
            for (int i = 0; i < listaLogs.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaLogs.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            System.out.println("Propiedad: " + hijo.getNodeName()
                                    + ", Valor: " + hijo.getTextContent());
                        }
 
                    }
                    System.out.println("");
                }
 
            }
 
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
	}
}
