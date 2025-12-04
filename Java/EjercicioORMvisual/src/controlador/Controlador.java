package controlador;

import java.util.ArrayList;

import modelo.*;

public class Controlador {
	
	public ArrayList<Provincias> provinciasList = new ArrayList<>();
	public ArrayList<Municipios> municipiosList = new ArrayList<>();
	
	public void cargarProvincias() {
		GestorProvincias gestorP = new GestorProvincias();
		provinciasList = gestorP.cargarProvincias();
	}
	
	public void cargarMunicipios(Provincias provincias) {
		GestorCargas gestor = new GestorCargas();
		gestor.cargarMunicipios(provincias);
	}
	
	public void incluir() {
		GestorProvincias gestorP = new GestorProvincias();
		gestorP.incluir();
	}

}
