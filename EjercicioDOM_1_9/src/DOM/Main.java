package DOM;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
			
			agregarCD(doc, "X100PRE", "Bad Bunny", "PR", "Sony", "12.99", "2018");

			// Guardar el documento actualizado en el archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(archivo);
			transformer.transform(source, result);

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
	
	public static void agregarCD(Document doc, String title, String artist, String country, String company, String price, String year) {
	    Element nuevoCD = doc.createElement("CD");

	    Element titulo = doc.createElement("TITLE");
	    titulo.setTextContent(title);
	    nuevoCD.appendChild(titulo);

	    Element artista = doc.createElement("ARTIST");
	    artista.setTextContent(artist);
	    nuevoCD.appendChild(artista);

	    Element pais = doc.createElement("COUNTRY");
	    pais.setTextContent(country);
	    nuevoCD.appendChild(pais);

	    Element sello = doc.createElement("COMPANY");
	    sello.setTextContent(company);
	    nuevoCD.appendChild(sello);

	    Element precio = doc.createElement("PRICE");
	    precio.setTextContent(price);
	    nuevoCD.appendChild(precio);

	    Element anio = doc.createElement("YEAR");
	    anio.setTextContent(year);
	    nuevoCD.appendChild(anio);

	    doc.getDocumentElement().appendChild(nuevoCD);
	}
	

}