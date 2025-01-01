
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/Hotel";  
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 
    // Método que devuelve la conexión
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Crear la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("No se encontró el driver JDBC", ex);
        }
    }
}
