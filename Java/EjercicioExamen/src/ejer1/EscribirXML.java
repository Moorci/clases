package ejer1;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import modelo.Libro;

public class EscribirXML {

	public static void generarXML(ArrayList<Libro> coleccionLibros, String destinoArchivo) {
		try {
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructor = fabrica.newDocumentBuilder();

			Document documento = constructor.newDocument();
			Element raiz = documento.createElement("peliculas");
			documento.appendChild(raiz);

			for (Libro item : coleccionLibros) {
				Element nodoLibro = documento.createElement("libro");
				nodoLibro.setAttribute("genero", item.getGenero());
				nodoLibro.setAttribute("valoracion", item.getRating());
				nodoLibro.setAttribute("publicado", String.valueOf(item.getAñoPublicacion()));
				raiz.appendChild(nodoLibro);

				agregarNodo(documento, nodoLibro, "titulo", item.getTitulo());

				for (String autor : item.getAutor()) {
					agregarNodo(documento, nodoLibro, "autor", autor);
				}
				for (String productor : item.getProducers()) {
					agregarNodo(documento, nodoLibro, "productor", productor);
					agregarNodo(documento, nodoLibro, "director", item.getDirector());
				}
				for (String personaje : item.getPersonajes()) {
					agregarNodo(documento, nodoLibro, "actor", personaje);
					agregarNodo(documento, nodoLibro, "comentario", item.getComentarios());
				}
			}

			Transformer transformador = TransformerFactory.newInstance().newTransformer();
			transformador.transform(new DOMSource(documento), new StreamResult(new File(destinoArchivo)));

			System.out.println("Archivo XML generado en: " + destinoArchivo);

		} catch (Exception ex) {
			System.err.println("Error al generar el XML: " + ex.getMessage());
		}
	}

	private static void agregarNodo(Document doc, Element padre, String etiqueta, String contenido) {
		Element nuevoElemento = doc.createElement(etiqueta);
		nuevoElemento.appendChild(doc.createTextNode(contenido));
		padre.appendChild(nuevoElemento);
	}
}