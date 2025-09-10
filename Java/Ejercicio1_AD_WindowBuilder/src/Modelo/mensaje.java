package Modelo;

import java.time.LocalTime;
import java.util.Date;

public class mensaje {
	
	private Date fecha;
	private LocalTime hora;
	private String remitente;
	private String receptor;
	private String asunto;
	private String contenido;
	
	public mensaje(Date fecha, LocalTime hora, String remitente, String receptor, String asunto, String contenido) {
		this.fecha = fecha;
		this.hora = hora;
		this.remitente = remitente;
		this.receptor = receptor;
		this.asunto = asunto;
		this.contenido = contenido;
	}
	
	public mensaje() {
		fecha = null;
		hora = null;
		remitente = "";
		receptor = "";
		asunto = "";
		contenido = "";
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "fecha = " + fecha +";"+ "hora = " + hora +";" + "remitente = " + remitente +";" + "receptor = " + receptor +";" 
	+ "asunto = " + asunto +";" + "contenido = " + contenido +";";
	}
}
