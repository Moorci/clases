package modelo;

import java.util.ArrayList;

import org.hibernate.Session;

import controlador.HibernateUtil;

public class GestorCargas {

	public ArrayList<Municipios> cargarMunicipios(Provincias provincia) {
		try (Session sesion = sesion()) {
            String query = "from Municipios where Municipios.provincias=" + provincia.getNombre();
            ArrayList<Municipios> municipios = (ArrayList<Municipios>) sesion.createQuery(query, Municipios.class).list();
            return municipios;
        }
	}
	private static Session sesion() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
