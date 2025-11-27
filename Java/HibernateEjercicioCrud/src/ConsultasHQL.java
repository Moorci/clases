
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Departamentos;
import modelo.Empleados;


public class ConsultasHQL {

	public static void main(String[] args) {
		//añadirDepartamento();
        //añadirDirector();
		//modificarGil();
		eliminarEmpleMadrid();
		
    }
	
	private static void eliminarEmpleMadrid() {
	    Session sesion = sesion(); // tu método para obtener la sesión
	    Transaction tx = null;

	    try {
	        tx = sesion.beginTransaction();

	        String sentencia = "from Empleados as emp where emp.apellido = 'GIL'";
	        Query<Departamentos> q = sesion.createQuery(sentencia, Departamentos.class);
	        Departamentos de = q.uniqueResult();

	        if (de != null) {
	            sesion.remove(de);
	            System.out.println("Departamento eliminado correctamente.");
	        } else {
	            System.out.println("No se encontró el departamento con id 20.");
	        }

	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        sesion.close();
	    }
	}


	private static void modificarGil() {
		Session sesion = sesion();
		Transaction tx = sesion.beginTransaction();
		
		String sentencia = "from Empleados as emp where emp.apellido = 'GIL'";
		Query<Empleados> q = sesion.createQuery(sentencia, Empleados.class);
		Empleados empleados = q.uniqueResult();

		empleados.setSalario((float) 1300);
		empleados.setFechaAlt(Date.valueOf(LocalDate.now().minusDays(1)));

		sesion.merge(empleados);
		System.out.println("Empleado gil modificado");
		tx.commit();
	}

	private static void añadirDirector() {
		
		Session sesion = sesion();
		Transaction tx = sesion.beginTransaction();
		
		Empleados empleado = new Empleados();

		empleado.setEmpNo((short) 8000);

		empleado.setOficio("EMPLEADO");

		empleado.setApellido("GONZALEZ");
		
		empleado.setSalario((float) 1700);
		
		empleado.setFechaAlt(Date.valueOf(LocalDate.now()));

		Departamentos dep = sesion.get(Departamentos.class, (byte) 50);

		empleado.setDepartamentos(dep);

		sesion.persist(empleado);

		System.out.println("Empleado creado en Informatica");
		tx.commit();
		
	}

	private static Session sesion() {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session sesion = session.openSession();
		return sesion;
	}

	private static void añadirDepartamento() {
		Session sesion = sesion();
		
		Transaction tx = sesion.beginTransaction();

        tx = sesion.beginTransaction();
        
        Departamentos depart = new Departamentos();
        depart.setDeptNo((byte) 50);
        depart.setDnombre("INFORMATICA");
        depart.setLoc("BILBAO");

        sesion.persist(depart);

        tx.commit();

        System.out.println("Departamento insertado correctamente.");
            
	}
	
}
