package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class Controlador {
	
	public ArrayList<Provincias> provinciasList = new ArrayList<>();
	
	public void cargarProvincias() {
		GestorProvincias gestorP = new GestorProvincias();
		provinciasList = gestorP.cargarProvincias();
	}
	
	public ArrayList<Municipios> cargarMunicipios(String nombre) {
		GestorCargas gestor = new GestorCargas();
		Provincias provincias = gestor.obtenerProvincia(nombre);
		return gestor.cargarMunicipios(provincias);
	}
	
	public ArrayList<CentrosMeteorologicos> cargarEstacionesMed(String nombreMuni) {
		GestorCargas gestor = new GestorCargas();
		Municipios municipio = gestor.obtenerMunicipio(nombreMuni);
		return gestor.cargarEstacionesMed(municipio);
	}
	
	public void incluir() {
		GestorProvincias gestorP = new GestorProvincias();
		gestorP.incluir();
	}

	public List<EspaciosNaturales> cargarEspaciosNat(String municipioNombre) {
		GestorCargas gestor = new GestorCargas();
		Municipios municipio = gestor.obtenerMunicipio(municipioNombre);
		return gestor.cargarEspaciosNat(municipio);
	}

	public String obtenerProvinciaDeMunicipio(String municipioNombre) {
		GestorCargas gestor = new GestorCargas();
		Municipios municipio = gestor.obtenerMunicipio(municipioNombre);
		Provincias provincia = gestor.obtenerProvinciaPorId(municipio.getIdProvincia());
		return provincia.getNombre();
	}

	public CentrosMeteorologicos obtenerEstacionMeteorologica(String nombreEstacion) {
		GestorCargas gestor = new GestorCargas();
		CentrosMeteorologicos estacion = gestor.obtenerEstacionMeteorologica(nombreEstacion);
		return estacion;
	}

	public List<MedicionesCentroMet> obtenerMedicionesCentroMet(Integer idCentroMet) {
		GestorCargas gestor = new GestorCargas();
		List<MedicionesCentroMet> mediciones = gestor.obtenerMedicionesCentroMet(idCentroMet);
		return mediciones;
	}

	public List<MedicionesCentroMetId> obtenerMasDatosMedicion(Integer idCentroMet) {
		GestorCargas gestor = new GestorCargas();
		List<MedicionesCentroMetId> medicionId = gestor.obtenerMasDatosMedicion(idCentroMet);
		return medicionId;
	}

}
