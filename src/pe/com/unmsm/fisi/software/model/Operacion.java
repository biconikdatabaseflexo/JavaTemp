package pe.com.unmsm.fisi.software.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.*;
import java.text.DecimalFormat;
import pe.com.unmsm.fisi.software.controller.gui.Catalogo;
import pe.com.unmsm.fisi.software.dao.AccesoDB;
import pe.com.unmsm.fisi.software.structure.ListaDoble;
import pe.com.unmsm.fisi.software.structure.Nodo;

public class Operacion {

    AccesoDB con = new AccesoDB();
    Connection cn = con.getConexion();

    //Admin admin = new Admin();

    public String mostrarFecha() {
        
        Calendar calendario = new GregorianCalendar();
        String fecha;
        String dia = Integer.toString(calendario.get(Calendar.DATE));
        String mes = Integer.toString(calendario.get(Calendar.MONTH));
        String anio = Integer.toString(calendario.get(Calendar.YEAR));
        String minuto = Integer.toString(calendario.get(Calendar.MINUTE));
        String hora = Integer.toString(calendario.get(Calendar.HOUR));
        String segundo = Integer.toString(calendario.get(Calendar.SECOND));

        fecha = dia + " - " + mes + " - " + anio + ". " + hora + ":" + minuto + ":" + segundo;

        return fecha;
    }

    public void imprimirBoleta(String nombre, int ticket, String total, ListaDoble lista) {
        Nodo nodo;
        nodo = lista.getCabecera();
        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        archivo = new File(ticket + ".txt");
        DecimalFormat df = new DecimalFormat("#0.00");

        try {
            archivo.createNewFile();
            escribir = new FileWriter(archivo);
            linea = new PrintWriter(escribir);
            linea.println("    " );
            linea.println("          JR. PARURO #1375");
            linea.println("          LIMA, LIMA, LIMA");
            linea.println("         R.U.C. 20556426130");
            linea.println("      ---------------------------");
            linea.println("NOMBRE: " + nombre);
            linea.println("TICKET Nº: " + ticket);
            linea.println("FECHA: " + mostrarFecha());
            linea.println("CANTIDAD         PRECIO         IMPORTE");
            linea.println("      ---------------------------");

            while (nodo != null) {
                linea.println(nodo.getModelo() + "   " + nodo.getDescripcion());
                linea.println("   " + nodo.getCantidad() + "              " + nodo.getPrecioUnitario() + "             " + df.format(nodo.getPrecioTotal()));
                nodo = nodo.getSiguiente();
            }

            linea.println("      ---------------------------");
            linea.println("                         TOTAL S/. " + total);
            linea.println("        GRACIAS POR SU COMPRA");
            linea.close();
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarStock(ListaDoble liston) {
        Nodo nodo;
        nodo = liston.getCabecera();
        int stockActual;
        int stockNuevo;

        while (nodo != null) {
            stockActual = getStock(nodo.getCodigo());
            stockNuevo = stockActual - nodo.getCantidad();
            cambiarDato(stockNuevo, nodo.getCodigo());
            nodo = nodo.getSiguiente();
        }
    }

    public int cambiarDato(int stockNuevo, int codigo) {
        int rsu = 0;
        String sqlB = "UPDATE `inventario` SET `STOCK`=" + stockNuevo + " WHERE `CODIGO`='" + codigo + "'";
        Statement st;
        try {
            st = cn.createStatement();
            rsu = st.executeUpdate(sqlB);
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rsu;
    }

    public int getStock(int codigo) {
        int stock = 0;
        String sql = "SELECT * FROM inventario WHERE CODIGO LIKE '" + codigo + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                stock = Integer.parseInt(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stock;
    }

    public int getTicket() {
        int ticket = 0;

        String sql = "SELECT * FROM ventas WHERE TICKET = (SELECT MAX( TICKET )  FROM ventas)";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ticket = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ticket;
    }

    public void registrarVenta(ListaDoble liston) {
        Nodo n;
        n = liston.getCabecera();
        int ticket = getTicket();
        while (n != null) {
            insertarVenta(n.getCliente(), n.getCodigo(), n.getDescripcion(), n.getModelo(),
                    n.getCantidad(), n.getPrecioUnitario(), n.getPrecioTotal());
            n = n.getSiguiente();
        }
    }

    public void insertarVenta(String cliente, int codigo, String descripcion, String modelo, int cantidad, double costoUni, double costoTotal) {
        int rsu = 0;
        //ticket++;
        String sql = "INSERT INTO `ventas` (`Cliente`, `Fecha`, `Codigo`, `Descripcion`, `Modelo`, `Cantidad`, `CostoUnitario`, `CostoTotal`, `Estado`) VALUES ('" + cliente + "', '" + mostrarFecha() + "', '" + codigo + "', '" + descripcion + "', '" + modelo + "', '" + cantidad + "', '" + costoUni + "', '" + costoTotal + "', 'CONFORME');";
        Statement st;
        try {
            st = cn.createStatement();
            rsu = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
