package main;

import java.util.ArrayList;
import ejer1.*;
import modelo.*;

public class PrincipalLibros {
    public static void main(String[] args) {

        ArrayList<Libro> libros;

        libros = LectorLibros.cargarLibros("Libros.txt");
        
        EscribirXML.crearXML(libros, "libros.xml");
        
        FiltroLibros.mostrarComedias(libros);
        
        EscribirTXT.crearArchivoActores(libros, "Personajes.txt");
    }
}
