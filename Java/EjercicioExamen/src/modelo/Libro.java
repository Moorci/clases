package modelo;

import java.util.ArrayList;

public class Libro {
	private String titulo;
	private ArrayList<String> autor;
	private String genero;
	private String rating;
	private int añoPublicacion;
	private String editorial;
	private String comentarios;
	private String Director;
	private ArrayList<String> publishers;
	private ArrayList<String> producers;
	private ArrayList<String> Personajes;

	public Libro() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<String> getAutor() {
		return autor;
	}

	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.añoPublicacion = anioPublicacion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public ArrayList<String> getPublishers() {
		return publishers;
	}

	public void setPublishers(ArrayList<String> publishers) {
		this.publishers = publishers;
	}

	public ArrayList<String> getProducers() {
		return producers;
	}

	public void setProducers(ArrayList<String> producers) {
		this.producers = producers;
	}

	public ArrayList<String> getPersonajes() {
		return Personajes;
	}

	public void setPersonajes(ArrayList<String> personajes) {
		Personajes = personajes;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}
	

	// Getters

}