package ejer1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Libro;

public class EscribirTXT {

	public static void guardarActoresConDirector(ArrayList<Libro> listaLibros, String destino) {
		try (PrintWriter escritor = new PrintWriter(new FileWriter(destino))) {
			escritor.println("Título\t\tDirector");
			escritor.println("-----------------------");

			for (Libro libro : listaLibros) {
				if (libro.getPersonajes() != null && libro.getPersonajes().size() >= 3) {
					escritor.println(libro.getTitulo() + "\t\t" + libro.getDirector());
				}
			}

			System.out.println("Archivo generado correctamente en: " + destino);

		} catch (IOException ex) {
			System.err.println("Error al escribir el archivo: " + ex.getMessage());
		}
	}
}