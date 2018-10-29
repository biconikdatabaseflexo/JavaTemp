package pe.com.unmsm.fisi.software.model;

/**
 *
 * @author Diego
 */
public class Cliente {
    
    private String nombre;
    private String dni;
    private Producto producto;
    private Integer cantidad;

    public Cliente(String nombre, String dni, Producto producto, Integer cantidad) {
        this.nombre = nombre;
        this.dni = dni;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
