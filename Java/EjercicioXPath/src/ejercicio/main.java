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

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xpathDoc = db.parse("ventas.xml");
            XPath xpath = XPathFactory.newInstance().newXPath();

            String expresion1 = "count(/tienda/ventas/venta[producto = /tienda/productos/producto[@venta = /tienda/dptos/dpto[nombre='Carnicería']/@id]/@id])";
            String expresion2 = "/tienda/productos/producto[@venta = /tienda/dptos/dpto[nombre='Carnicería']/@id]/precio";
            String expresion3 = "/tienda/productos/producto[@id = /tienda/ventas/venta[cantidad=3]/producto]/nombre";
            String expresion4 = "/tienda/dptos/dpto[@id = /tienda/productos/producto[nombre='Naranjas']/@venta]/responsable";
            String expresion5 = "/tienda/dptos/dpto[@id = /tienda/productos/producto[@id = /tienda/ventas/venta[data='2013/3/10']/producto]/@venta]/responsable";

            Double countVentas = (Double) xpath.evaluate(expresion1, xpathDoc, XPathConstants.NUMBER);
            System.out.println("Cantidad de ventas en Carnicería: " + countVentas);

            NodeList preciosCarniceria = (NodeList) xpath.evaluate(expresion2, xpathDoc, XPathConstants.NODESET);
            NodeList nombresCantidad3 = (NodeList) xpath.evaluate(expresion3, xpathDoc, XPathConstants.NODESET);
            NodeList responsableNaranjas = (NodeList) xpath.evaluate(expresion4, xpathDoc, XPathConstants.NODESET);
            NodeList responsableFecha = (NodeList) xpath.evaluate(expresion5, xpathDoc, XPathConstants.NODESET);

            System.out.println("\nPrecios de productos en Carnicería:");
            for (int i = 0; i < preciosCarniceria.getLength(); i++) {
                System.out.println(preciosCarniceria.item(i).getTextContent());
            }

            System.out.println("\nNombre de productos vendidos con cantidad = 3:");
            for (int i = 0; i < nombresCantidad3.getLength(); i++) {
                System.out.println(nombresCantidad3.item(i).getTextContent());
            }

            System.out.println("\nResponsable del departamento que vende Naranjas:");
            for (int i = 0; i < responsableNaranjas.getLength(); i++) {
                System.out.println(responsableNaranjas.item(i).getTextContent());
            }

            System.out.println("\nResponsable del departamento de venta del 2013/3/10:");
            for (int i = 0; i < responsableFecha.getLength(); i++) {
                System.out.println(responsableFecha.item(i).getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}