package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String url = "jdbc:mysql://localhost:3306/empresa";
    String usuario = "root";
    String clave = "";

    public Connection getConexion() {
        try {
            return DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
