package DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		try {

			File archivo = new File("cds.xml");
			DocumentBuilderFactory dbFactoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoria.newDocumentBuilder();

			Document doc = dBuilder.parse(archivo);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("CD");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("\nCD :" + i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				    Element cd = (Element) nNode;

				    System.out.println("Titulo : " + cd.getElementsByTagName("TITLE").item(0).getTextContent());
				    System.out.println("Artista : " + cd.getElementsByTagName("ARTIST").item(0).getTextContent());
				    System.out.println("Pais : " + cd.getElementsByTagName("COUNTRY").item(0).getTextContent());
				    System.out.println("Sello : " + cd.getElementsByTagName("COMPANY").item(0).getTextContent());
				    System.out.println("Precio : " + cd.getElementsByTagName("PRICE").item(0).getTextContent());
				    System.out.println("Año : " + cd.getElementsByTagName("YEAR").item(0).getTextContent());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
