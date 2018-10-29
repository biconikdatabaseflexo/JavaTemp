package pe.com.unmsm.fisi.software.model;

/**
 *
 * @author Diego
 */
public class Producto {

    private Integer codigo;
    private String nombre;
    private String modelo;
    private Integer stock;
    private Float precioUnitario;

    public Producto(Integer codigo, String nombre, String modelo, Integer stock, Float precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    //-------------------------------------------------------
    public void aumentarStock(Integer stockAumentado) {
        this.stock += stockAumentado;
    }
}
