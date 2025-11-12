package ejer1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Libro;

public class LectorLibros {

	public static ArrayList<Libro> cargarLibros(String ruta) {
		ArrayList<Libro> listaLibros = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String lineaActual;
			Libro libroActual = null;

			while ((lineaActual = br.readLine()) != null) {
				lineaActual = lineaActual.trim();
				if (lineaActual.isEmpty())
					continue;

				String[] partes = lineaActual.split("=");
				if (partes.length < 2)
					continue;

				String campo = partes[0].trim().toLowerCase();
				String contenido = partes[1].trim();

				if ((contenido.startsWith("\"") && contenido.endsWith("\""))
						|| (contenido.startsWith("'") && contenido.endsWith("'"))) {
					contenido = contenido.substring(1, contenido.length() - 1);
				}

				switch (campo) {
				case "title":
					libroActual = new Libro();
					libroActual.setTitulo(contenido);
					break;
				case "writer":
					libroActual.setAutor(separarPorComas(contenido));
					break;
				case "type":
					libroActual.setGenero(contenido);
					break;
				case "year":
					libroActual.setAnioPublicacion(Integer.parseInt(contenido));
					break;
				case "publisher":
					if (libroActual.getPublishers() == null) {
						libroActual.setPublishers(new ArrayList<>());
					}
					libroActual.getPublishers().add(contenido);
					break;
				case "producer":
					if (libroActual.getProducers() == null) {
						libroActual.setProducers(new ArrayList<>());
					}
					libroActual.getProducers().add(contenido);
					break;
				case "actor":
					libroActual.setPersonajes(separarPorComas(contenido));
					break;
				case "editorial":
					libroActual.setEditorial(contenido);
					break;
				case "rating":
					libroActual.setRating(contenido);
					break;
				case "comments":
					libroActual.setComentarios(contenido);
					break;
				case "director":
					libroActual.setDirector(contenido);
					listaLibros.add(libroActual);
					break;
				default:
					break;
				}
			}

			if (libroActual != null && !listaLibros.contains(libroActual)) {
				listaLibros.add(libroActual);
			}

			System.out.println("Lectura completada desde: " + ruta);

		} catch (IOException ex) {
			System.err.println("No se pudo leer el archivo: " + ex.getMessage());
		}

		return listaLibros;
	}

	private static ArrayList<String> separarPorComas(String texto) {
		ArrayList<String> resultado = new ArrayList<>();
		for (String parte : texto.split(",")) {
			resultado.add(parte.trim());
		}
		return resultado;
	}
}