package ejercicio;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class main {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
		
		Document xpathDoc = db.parse("ventas.xml");
		XPath xpath = XPathFactory.newInstance().newXPath();
		
	
		String expresion = "count(/tienda/ventas/venta[producto = /tienda/productos/producto[@venta = /tienda/dptos/dpto[nombre='Carnicería']/@id]/@id])\r\n";
		String expresion2 = "/tienda/productos/producto[@venta = /tienda/dptos/dpto[nombre='Carnicería']/@id]/precio\r\n";
		String expresion3 = "/tienda/productos/producto[@id = /tienda/ventas/venta[cantidad=3]/producto]/nombre\r\n";
		String expresion4 = "/tienda/dptos/dpto[@id = /tienda/productos/producto[nombre='Naranjas']/@venta]/responsable";
		String expresion5 = "/tienda/dptos/dpto[@id = /tienda/productos/producto[@id = /tienda/ventas/venta[data='2013/3/10']/producto]/@venta]/responsable\r\n";
		//String expresion = "//book[author = 'Neal Stephenson']/ title";
		
		NodeList ventas = (NodeList) xpath.evaluate(expresion,  xpathDoc,XPathConstants.NODESET);
		NodeList ventas2 = (NodeList) xpath.evaluate(expresion2,  xpathDoc,XPathConstants.NODESET);
		NodeList ventas3 = (NodeList) xpath.evaluate(expresion3,  xpathDoc,XPathConstants.NODESET);
		NodeList ventas4 = (NodeList) xpath.evaluate(expresion4,  xpathDoc,XPathConstants.NODESET);
		NodeList ventas5 = (NodeList) xpath.evaluate(expresion5,  xpathDoc,XPathConstants.NODESET);
		
		for(int i =0;i<libros.getLength();i++)
		{
			System.out.println(libros.item(i).getNodeValue());
		}
	
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
