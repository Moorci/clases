package modelo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import controlador.HibernateUtil;

public class GestorProvincias {

	public ArrayList<Provincias> cargarProvincias() {
		
		Session sesion = sesion();
	    Transaction tx = null;
	    ArrayList<Provincias> provincias = new ArrayList<>();

	    try {
	        tx = sesion.beginTransaction();
	        String sentencia = "from Provincias";
	        Query<Provincias> query = sesion.createQuery(sentencia, Provincias.class);
	        provincias = (ArrayList<Provincias>) query.list();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        sesion.close();
	    }
	    return provincias;
	}
	
	public Provincias añadirProvincia() {
		Provincias provincia = new Provincias();
		
		
		
		return provincia;
	}

	private static Session sesion() {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session sesion = session.openSession();
		return sesion;
	}
}
