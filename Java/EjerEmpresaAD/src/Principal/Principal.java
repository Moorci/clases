package Principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.Conexion;

public class Principal {

	public static void main(String[] args) {
		mostrarDepartamentos();
		System.out.println();
		mostrarEmpleadosSalarioMax();
		System.out.println();
		mostrarEmpleadosDept10();
	}

	private static void mostrarEmpleadosSalarioMax() {
		System.out.println("Empleado con mayor salario: ");
		Conexion conexionBD = new Conexion();
	    String sql = "SELECT apellido, salario, dept_no FROM empleados ORDER BY salario DESC LIMIT 1";

	    try (Connection con = conexionBD.getConexion();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        if (rs.next()) {
	            System.out.println("Apellido: " + rs.getString("apellido") + ", Salario: " + rs.getDouble("salario") + ", Departamento: " + rs.getInt("dept_no"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	private static void mostrarDepartamentos() {
		System.out.println("Departamentos: ");
		Conexion conexionBD = new Conexion();
        try (Connection con = conexionBD.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM departamentos")) {

            while (rs.next()) {
                System.out.println("Dept_no: " + rs.getInt("dept_no") + ", Nombre: " + rs.getString("dnombre") + ", Localidad: " + rs.getString("loc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	private static void mostrarEmpleadosDept10() {
		System.out.println("Empleados del departamento 10: ");
	    Conexion conexionBD = new Conexion();
	    String sql = "SELECT apellido, oficio, salario FROM empleados WHERE dept_no = 10";

	    try (Connection con = conexionBD.getConexion();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	            System.out.println("Apellido: " + rs.getString("apellido") +
	                               ", Oficio: " + rs.getString("oficio") +
	                               ", Salario: " + rs.getDouble("salario"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
