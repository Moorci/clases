package ejer1;



import java.util.ArrayList;

import modelo.Libro;

public class FiltroLibros {
	  public static void mostrarComedias(ArrayList<Libro> libros) {
	        System.out.println(" Comedias:");
	        for (Libro p : libros) {
	            if ("comedy".equalsIgnoreCase(p.getGenero())) {
	                System.out.println(p.getTitulo() + " - " + p.getRating() + " (" + p.getAñoPublicacion() + ")");
	            }
	        }
	    }
   
}