package modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import controlador.HibernateUtil;

public class GestorCargas {

	public Provincias obtenerProvincia(String nombre) {
	    try (Session sesion = sesion()) {
	        String hql = "from Provincias p where p.nombre = :nombre";
	        Provincias provincia = sesion
	            .createQuery(hql, Provincias.class)
	            .setParameter("nombre", nombre)
	            .uniqueResult();
	        return provincia;
	    }
	}
	
	public ArrayList<Municipios> cargarMunicipios(Provincias provincia) {
	    try (Session sesion = sesion()) {
	        String hql = "from Municipios m where m.idProvincia = :idProvincia";
	        ArrayList<Municipios> municipios = (ArrayList<Municipios>) sesion
	            .createQuery(hql, Municipios.class)
	            .setParameter("idProvincia", provincia.getIdProvincia())
	            .list();
	        return municipios;
	    }
	}
	private static Session sesion() {
        return HibernateUtil.getSessionFactory().openSession();
    }

	public ArrayList<CentrosMeteorologicos> cargarEstacionesMed(Municipios municipio) {
		try (Session sesion = sesion()) {
	        String hql = "from CentrosMeteorologicos c where c.idMunicipio = :idMunicipio";
	        ArrayList<CentrosMeteorologicos> estaciones = (ArrayList<CentrosMeteorologicos>) sesion
	            .createQuery(hql, CentrosMeteorologicos.class)
	            .setParameter("idMunicipio", municipio.getIdMunicipio())
	            .list();
	        return estaciones;
	    }
	}

	public Municipios obtenerMunicipio(String nombreMuni) {
		try (Session sesion = sesion()) {
	        String hql = "from Municipios m where m.nombre = :nombre";
	        Municipios municipio = sesion
	            .createQuery(hql, Municipios.class)
	            .setParameter("nombre", nombreMuni)
	            .uniqueResult();
	        return municipio;
	    }
		
	}

	public List<EspaciosNaturales> cargarEspaciosNat(Municipios municipio) {
		try (Session sesion = sesion()) {
			String hql = "select e " +
		             "from EspaciosNaturales e, MunicipiosEspaciosNat me " +
		             "where e.idEspacio = me.id.idEspacio " +
		             "and me.id.idMunicipio = :idMunicipio";

			List<EspaciosNaturales> espacios = sesion.createQuery(hql, EspaciosNaturales.class)
				    .setParameter("idMunicipio", municipio.getIdMunicipio())
				    .list();
	        return espacios;
	    }
	}

	public Provincias obtenerProvinciaPorId(Integer idProvincia) {
		try (Session sesion = sesion()) {
	        String hql = "from Provincias p where p.idProvincia = :idProvincia";
	        Provincias provincia = sesion
	            .createQuery(hql, Provincias.class)
	            .setParameter("idProvincia", idProvincia)
	            .uniqueResult();
	        return provincia;
	    }
	}

	public CentrosMeteorologicos obtenerEstacionMeteorologica(String nombreEstacion) {
		try (Session sesion = sesion()) {
	        String hql = "from CentrosMeteorologicos c where c.nombre = :nombre";
	        CentrosMeteorologicos estacion = sesion
	            .createQuery(hql, CentrosMeteorologicos.class)
	            .setParameter("nombre", nombreEstacion)
	            .uniqueResult();
	        return estacion;
	    }
	}

	public List<MedicionesCentroMet> obtenerMedicionesCentroMet(Integer idCentroMet) {
	    try (Session sesion = sesion()) {
	        String hql = "from MedicionesCentroMet m where m.id.idCentroMet = :idCentroMet";
	        
	        List<MedicionesCentroMet> mediciones = sesion
	            .createQuery(hql, MedicionesCentroMet.class)
	            .setParameter("idCentroMet", idCentroMet)
	            .list();
	        System.out.println("mediciones cargadas" + mediciones.size());
	        return new ArrayList<>(mediciones);
	    }
	}

	public List<MedicionesCentroMetId> obtenerMasDatosMedicion(Integer idCentroMet) {
	    try (Session sesion = sesion()) {
	        String hql = "from MedicionesCentroMet m where m.id.idCentroMet = :idCentroMet";
	        
	        List<MedicionesCentroMet> mediciones = sesion
	            .createQuery(hql, MedicionesCentroMet.class)
	            .setParameter("idCentroMet", idCentroMet)
	            .list();
	        
	        List<MedicionesCentroMetId> mcmi = new ArrayList<>();
	        for (MedicionesCentroMet m : mediciones) {
	        	mcmi.add(m.getId());
	        }
	        
	        return mcmi;
	    }
	}

}
