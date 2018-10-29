package pe.com.unmsm.fisi.software.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConsultaSQL {

    private Connection con;
    private ResultSet rs;
    private ResultSetMetaData mtd;
    private String[] columnas;
    private String consulta;
    private String error;

    public ConsultaSQL(Connection con, String sql) {
        this.con = con;
        this.consulta = sql;

        try {
            Statement st = con.createStatement();

            rs = st.executeQuery(consulta);

            mtd = rs.getMetaData();

            error = null;

        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, "Se ha generado un error con el Query.");
        }
    }

    public String getError() {
        return this.error;
    }

    public ResultSet getResultado() {
        return this.rs;
    }

    public String[] getNombresColumnas() {

        try {
            int numCol = mtd.getColumnCount();
            this.columnas = new String[numCol];

            for (int a = 1; a <= numCol; a++) {
                columnas[a] = mtd.getColumnLabel(a); //La posicion en la que inicia el RS es 1
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la cantidad de columnas.");
        }

        return columnas;
    }

}
