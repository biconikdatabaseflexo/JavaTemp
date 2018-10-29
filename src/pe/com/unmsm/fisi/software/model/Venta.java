package pe.com.unmsm.fisi.software.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.unmsm.fisi.software.controller.gui.Catalogo;
import pe.com.unmsm.fisi.software.dao.AccesoDB;
import pe.com.unmsm.fisi.software.service.ConsultaSQL;
import pe.com.unmsm.fisi.software.structure.ListaDoble;
import pe.com.unmsm.fisi.software.structure.Nodo;

/**
 *
 * @author Diego
 */
public class Venta {

    //AccesoDB cn = new AccesoDB();
    ResultSet rs;
    String consulta = "SELECT * FROM admin";
    AccesoDB con = new AccesoDB();
    Connection cn = con.getConexion();

    /*Conector cn = new Conector("root", "", "dump_000000001", "localhost");
    ConsultaSQL cn = new ConsultaSQL(cn.getConexion(), consulta);*/
    public String getFecha() {
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

    public String getTienda() {
        String tienda = "";

        String sql = "SELECT NombreTienda FROM admin";

        Statement statement;
        try {
            statement = cn.createStatement();
            //ResultSet rs= statement.executeQuery(sql);

            tienda = (String) rs.getObject("NombreTienda");
        } catch (SQLException ex) {
            System.out.println("Chuchito-sama");
        }

        return tienda;
    }

    public String getDireccion() {
        String direccion = "";

        String sql = "SELECT Direccion FROM admin";

        Statement statement;
        try {
            statement = cn.createStatement();
            //ResultSet rs= statement.executeQuery(sql);

            direccion = (String) rs.getObject("Direccion");
        } catch (SQLException ex) {
            System.out.println("Chuchito-sama2");
        }

        return direccion;
    }

    public String getDireccionGeneral() {
        String direccion = "";

        String sql = "SELECT DireccionGeneral FROM admin";

        Statement statement;
        try {
            statement = cn.createStatement();
            //ResultSet rs= statement.executeQuery(sql);

            direccion = (String) rs.getObject("DireccionGeneral");
        } catch (SQLException ex) {
            System.out.println("Chuchito-sama3");
        }

        return direccion;
    }

    public String getRuc() {
        String ruc = "";

        String sql = "SELECT Ruc FROM admin";

        Statement statement;
        try {
            statement = cn.createStatement();
            //ResultSet rs= statement.executeQuery(sql);

            ruc = (String) rs.getObject("Ruc");
        } catch (SQLException ex) {
            System.out.println("Chuchito-sama4");
        }

        return ruc;
    }

    public String getNombre() {
        String nombre = "";

        String sql = "SELECT Nombre FROM admin";

        Statement statement;
        try {
            statement = cn.createStatement();
            //ResultSet rs= statement.executeQuery(sql);

            nombre = (String) rs.getObject("Nombre");
        } catch (SQLException ex) {
            System.out.println("Chuchito-sama5");
        }

        return nombre;
    }

    //------------------------------------------------------------------------
    public void imprimirBoleta(String nombre, int numero, String total, ListaDoble lista) {
        Nodo nodo;
        nodo = lista.getCabecera();
        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        archivo = new File(numero + ".txt");
        DecimalFormat df = new DecimalFormat("#0.00");
        //-----
        String sql = "SELECT * FROM admin";

        String dato[] = new String[6];
        Statement st;

        //----
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                dato[0] = rs.getString(9);
                dato[1] = rs.getString(10);
                dato[2] = rs.getString(11);
                dato[3] = rs.getString(8);
                dato[4] = rs.getString(4);
                //dato[5] = rs.getString();
            }

            archivo.createNewFile();
            escribir = new FileWriter(archivo);
            linea = new PrintWriter(escribir);
            linea.println("\t\t" + dato[0]);
            linea.println("\tDireccion: " + dato[1]);
            linea.println("\tCiudad: " + dato[2]);
            linea.println("\tRUC: " + dato[3]);
            linea.println("\t------------------------------------");
            linea.println("CLIENTE: " + nombre);
            linea.println("NOMBRE: " + dato[4]);
            linea.println("TICKET Nº: " + numero);
            linea.println("FECHA : " + getFecha());
            linea.println("CANTIDAD         PRECIO         IMPORTE");
            linea.println("\t------------------------------------");

            while (nodo != null) {
                linea.println(nodo.getModelo() + "   " + nodo.getDescripcion());
                linea.println("   " + nodo.getCantidad() + "              " + nodo.getPrecioUnitario() + "             " + df.format(nodo.getPrecioTotal()));
                nodo = nodo.getSiguiente();
            }

            linea.println("\t---------------------------");
            linea.println("\t\tTOTAL S/. " + total);
            linea.println("\tGRACIAS POR SU COMPRA");
            linea.close();
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
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
                stock = Integer.parseInt(rs.getString(5)); //BD
            }
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stock;
    }

    public int getTicket() {
        int ticket = 1;

        String sql = "SELECT * FROM ventas WHERE Ticket = (SELECT MAX( Ticket )  "
                + "FROM ventas)";
        Statement st;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ticket = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ticket;
    }

    
    private int ticket = 1;
    public void registrarVenta(ListaDoble liston) {
        Nodo nodo;
        nodo = liston.getCabecera();
        
        /*String sql = "SELECT * FROM ventas WHERE Ticket = (SELECT MAX( Ticket )  "
                + "FROM ventas)";
        Statement st;
        
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ticket = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("nel");
        }*/
        
        int count = 0;
        while (nodo != null) {
            //Al ingresar a la base de datos más de un producto para el mismo comprador
            //Este if ayuda a que se siga repitiendo el nombre del comprador hasta que
            //Se termine la compra
            if (count != 0) {
                nodo.setCliente(nodo.getAnterior().getCliente());
            }
            insertarVenta(ticket, nodo.getCliente(), nodo.getCodigo(), nodo.getDescripcion(),
                    nodo.getModelo(),
                    nodo.getCantidad(), nodo.getPrecioUnitario(), nodo.getPrecioTotal());
            count++;
            nodo = nodo.getSiguiente();
        }
        ticket++;

    }

    public void insertarVenta(Integer ticket, String cliente, int codigo, String descripcion, String modelo,
            int cantidad, double costoUni, double costoTotal) {

        int rsu = 0;

        String sql = "INSERT INTO ventas(`Ticket`,`Cliente`, `Codigo`, `Descripcion`,"
                + " `Modelo`, `Cantidad`, `CostoUnitario`, `CostoTotal`, `Estado`) "
                + "VALUES ('" + ticket + "', '" + cliente + "', '" + codigo + "', '"
                + descripcion + "', '" + modelo + "', '" + cantidad + "', '"
                + costoUni + "', '" + costoTotal + "', 'CONFORME');";

        /*INSERT INTO ventas
        (Cliente,Codigo,Descripcion,Modelo,Cantidad,CostoUnitario,CostoTotal,Estado)
        VALUES ("Lara Robledo","100107400","NAND DE 2 ENTRADAS CUADRUPLE","74LS00",
        10,1.4,14,"CONFORME")
         */
        Statement st;
        try {
            st = cn.createStatement();
            rsu = st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
