package pe.com.unmsm.fisi.software.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Grupo1
 */
public class AccesoDB {

    private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "dump_000000001";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private Connection cn;

    public AccesoDB() {
        try {
            Class.forName(CLASSNAME);
            cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("ERROR: " + e);
        }
    }

    public Connection getConexion() {
        return cn;
    }
}
