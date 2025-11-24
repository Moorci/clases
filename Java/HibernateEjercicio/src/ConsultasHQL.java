
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import modelo.Departamentos;
import modelo.Empleados;

public class ConsultasHQL {

	public static void main(String[] args) {
		
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session sesion = session.openSession();
		
		//Ejercicio 1
		String hql = "from Empleados emp where emp.departamentos.deptNo = 10";
		Query<Empleados> q = sesion.createQuery(hql, Empleados.class);
		ArrayList<Empleados> empleados = (ArrayList<Empleados>) q.list();
		
		System.out.println("Empleados del departamento 10:\n");
		for(int i = 0; i < empleados.size(); i++) {
			System.out.println(empleados.get(i).getApellido());
			System.out.println(empleados.get(i).getOficio());
			System.out.println(empleados.get(i).getSalario());
			System.out.println("--------------------");
		}
		
		//Ejercicio 2
		String hql2 = "from Empleados emp where emp.salario = (select max(e.salario) from Empleados e)";
		Query<Empleados> q2 = sesion.createQuery(hql2, Empleados.class);
		ArrayList<Empleados> empleados2 = (ArrayList<Empleados>) q2.list();
		
		System.out.println("\nEmpleado con salario max:\n");
		for(int i = 0; i < empleados2.size(); i++) {
			System.out.println(empleados2.get(i).getApellido());
			System.out.println(empleados2.get(i).getSalario());
			System.out.println(empleados2.get(i).getDepartamentos().getDnombre());
			System.out.println("--------------------");
		}
		
		//Ejercicio 3
		String hql3 = "from Departamentos where dnombre = 'CONTABILIDAD' or dnombre = 'INVESTIGACION'";
		Query<Departamentos> q3 = sesion.createQuery(hql3, Departamentos.class);
		ArrayList<Departamentos> departamentos3 = (ArrayList<Departamentos>) q3.list();
		
		System.out.println("\nDepartamentos Contabilidad e investigacion:\n");
		for(int i = 0; i < departamentos3.size(); i++) {
			System.out.println(departamentos3.get(i).getDnombre());
			System.out.println(departamentos3.get(i).getLoc());
			System.out.println(departamentos3.get(i).getDeptNo());
			System.out.println("--------------------");
		}
		
		//Ejercicio 4
		String hql4 = "from Empleados where departamentos.dnombre = 'CONTABILIDAD' and oficio = 'DIRECTOR'";
		Query<Empleados> q4 = sesion.createQuery(hql4, Empleados.class);
		ArrayList<Empleados> empleados4 = (ArrayList<Empleados>) q4.list();
		
		System.out.println("\nEmpleados de contabilidad y oficio director:\n");
		for(int i = 0; i < empleados4.size(); i++) {
			System.out.println(empleados4.get(i).getApellido());
			System.out.println(empleados4.get(i).getOficio());
			System.out.println(empleados4.get(i).getComision());
			System.out.println(empleados4.get(i).getDir());
			System.out.println(empleados4.get(i).getSalario());
			System.out.println(empleados4.get(i).getFechaAlt());
			System.out.println("--------------------");
		}
		
		//Ejercicio 5
		String hql5 = "from Empleados where fechaAlt = '1990-12-17'";
		Query<Empleados> q5 = sesion.createQuery(hql5, Empleados.class);
		ArrayList<Empleados> empleados5 = (ArrayList<Empleados>) q5.list();
		
		System.out.println("\nEmpleados con fecha de alta 1990-12-17:\n");
		for(int i = 0; i < empleados5.size(); i++) {
			System.out.println(empleados5.get(i).getApellido());
			System.out.println(empleados5.get(i).getOficio());
			System.out.println(empleados5.get(i).getComision());
			System.out.println(empleados5.get(i).getDir());
			System.out.println(empleados5.get(i).getSalario());
			System.out.println(empleados5.get(i).getFechaAlt());
			System.out.println("--------------------");
		}
		
		//Ejercicio 6
		String hql6 = "from Empleados emp where  emp.salario = (select max(e2.salario) from Empleados e2 where e2.departamentos.loc = 'MADRID')"
				+ " and emp.departamentos.loc = 'MADRID'";
		Query<Empleados> q6 = sesion.createQuery(hql6, Empleados.class);
		ArrayList<Empleados> empleados6 = (ArrayList<Empleados>) q6.list();
		
		System.out.println("\nEmpleados de Madrid con mejor salario:\n");
		for(int i = 0; i < empleados6.size(); i++) {
			System.out.println(empleados6.get(i).getApellido());
			System.out.println(empleados6.get(i).getOficio());
			System.out.println(empleados6.get(i).getComision());
			System.out.println(empleados6.get(i).getDir());
			System.out.println(empleados6.get(i).getSalario());
			System.out.println(empleados6.get(i).getFechaAlt());
			System.out.println("--------------------");
		}
		//Ejercicio 7
		String hql7 = "select d.salario " +
	              "from Empleados d " +
	              "where d.empNo = (" +
	              "   select e.dir " +
	              "   from Empleados e " +
	              "   where e.comision = (select max(emp.comision) from Empleados emp)" +
	              ")";

		Query<Float> q7 = sesion.createQuery(hql7, Float.class);
		Float salarioDirector = q7.uniqueResult();
	
		System.out.println("Salario del director: " + salarioDirector);

		
		
		//Ejercicio 8
		String hql8 = "from Empleados emp " +
	              "where emp.departamentos.loc = 'BARCELONA' " +
	              "order by emp.salario desc";

		Query<Empleados> q8 = sesion.createQuery(hql8, Empleados.class);
		q8.setMaxResults(1);
	
		Empleados empleadoMaxBarcelona = q8.uniqueResult();
		System.out.println("Fecha de alta: " + empleadoMaxBarcelona.getFechaAlt());
		
		session.close();
		sesion.close();
		
	}
	
}
