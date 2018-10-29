package pe.com.unmsm.fisi.software.model;

/**
 *
 * @author Diego
 */
public class Admin {

    private String usuario;
    private String contrasena;
    private String nombreTienda;
    private String direccion;
    private String direccionGeneral;
    private String ruc;
    private String nombres;
    private String apellidos;
    private String fechaCreacion;
    private Integer dni;
    private Integer telefono;
    private Integer actualizado;

    public Admin(String usuario, String contrasena, String tienda,
            String direccion, String direccionGeneral, String ruc,
            String nombres, String apellidos, Integer dni,
            Integer telefono) {
        
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombreTienda = tienda;
        this.direccion = direccion;
        this.direccionGeneral = direccionGeneral;
        this.ruc = ruc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
       
    }

    public Admin(String usuario, String contrasena, String nombreTienda, String direccion, String direccionGeneral, String ruc, String nombres, String apellidos, String fechaCreacion, Integer dni, Integer telefono) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombreTienda = nombreTienda;
        this.direccion = direccion;
        this.direccionGeneral = direccionGeneral;
        this.ruc = ruc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaCreacion = fechaCreacion;
        this.dni = dni;
        this.telefono = telefono;
        
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTienda() {
        return nombreTienda;
    }

    public void setTienda(String tienda) {
        this.nombreTienda = tienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionGeneral() {
        return direccionGeneral;
    }

    public void setDireccionGeneral(String direccionGeneral) {
        this.direccionGeneral = direccionGeneral;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getActualizado() {
        return actualizado;
    }

    public void setActualizado(Integer actualizado) {
        this.actualizado = actualizado;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    

    //-------------------------------------------------------
    public int compare(Admin o1, Admin o2) {
        return o1.getApellidos().compareTo(o2.apellidos);
    }
}
