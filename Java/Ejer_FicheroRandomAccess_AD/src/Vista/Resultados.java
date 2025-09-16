package Vista;

import java.io.Serializable;
import java.time.LocalDate;


public class Resultados implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombreLocal;
	private String nombreVisit;
	private int golesLocal;
	private int golesVisit;
	private String lugar;
	private LocalDate Fecha;
	public String getNombreLocal() {
		return nombreLocal;
	}
	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
	public String getNombreVisit() {
		return nombreVisit;
	}
	public void setNombreVisit(String nombreVisit) {
		this.nombreVisit = nombreVisit;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVisit() {
		return golesVisit;
	}
	public void setGolesVisit(int golesVisit) {
		this.golesVisit = golesVisit;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public LocalDate getFecha() {
		return Fecha;
	}
	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}
	public Resultados(String nombreLocal, String nombreVisit, int golesLocal, int golesVisit, String lugar,
			LocalDate fechaLD) {
		this.nombreLocal = nombreLocal;
		this.nombreVisit = nombreVisit;
		this.golesLocal = golesLocal;
		this.golesVisit = golesVisit;
		this.lugar = lugar;
		Fecha = fechaLD;
	}
	
	public Resultados() {
		nombreLocal = null;
		nombreVisit = null;
		golesLocal = 0;
		golesVisit = 0;
		lugar = null;
		Fecha = null;
	}
	@Override
	public String toString() {
		return "Nombre Local = " + nombreLocal + "; Nombre Visitante = " + nombreVisit + "; Goles Local = " + golesLocal
				+ "; Goles Visit = " + golesVisit + "; Lugar = " + lugar + "; Fecha = " + Fecha;
	}
	
	
}
