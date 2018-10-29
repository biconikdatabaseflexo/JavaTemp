/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.fisi.software.structure;

import pe.com.unmsm.fisi.software.model.Producto;

/**
 *
 * @author Grupo1
 */
public class Nodo {

    //private Producto producto;
    private Integer boleta = 1;
    private Integer codigo;
    private String cliente;
    private String modelo;
    private String descripcion;

    private Integer cantidad;
    private Float precioUnitario;
    private Float precioTotal;

    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Integer boleta, Integer codigo, String modelo, String descripcion, Integer cantidad,
            Float precioUnitario, Float precioTotal) {

        this.boleta = boleta;
        this.codigo = codigo;
        //producto.setCodigo(codigo);
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;

        siguiente = anterior = null;
    }

    public Nodo(Integer boleta, String cliente, Integer codigo, String modelo, String descripcion, Integer cantidad,
            Float precioUnitario, Float precioTotal) {

        this.boleta = boleta;
        this.cliente = cliente;
        this.codigo = codigo;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;

        siguiente = anterior = null;
    }

    public Integer getBoleta() {
        return boleta;
    }

    public void setBoleta(Integer boleta) {
        this.boleta = boleta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return getModelo() + "   " + getDescripcion() + "\n" + "   "
                + getCantidad() + " Pza:   " + getPrecioUnitario() + "      "
                + getPrecioTotal() + "\n";
    }

}
