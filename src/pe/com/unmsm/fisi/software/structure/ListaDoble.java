/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.fisi.software.structure;

/**
 *
 * @author CESAR
 */
public class ListaDoble {

    Nodo cabecera;

    public Nodo getCabecera() {
        return cabecera;
    }

    public void setCabecera(Nodo cabecera) {
        this.cabecera = cabecera;
    }

    public Nodo getPuntero() {
        return puntero;
    }

    public void setPuntero(Nodo puntero) {
        this.puntero = puntero;
    }
    Nodo puntero;

    public ListaDoble() {
        cabecera = puntero = null;
    }

    public boolean esVacia() {
        boolean consulta = false;
        if (cabecera == null) {
            consulta = true;
        }
        return consulta;
    }

    public ListaDoble insertar(Integer boleta, int codigo, String modelo, String descripcion,
            int cantid, float precioUni, float precioTot) {

        Nodo nuevo = new Nodo(boleta, codigo, modelo, descripcion, cantid, precioUni, precioTot);
        if (esVacia()) {
            cabecera = puntero = nuevo;
        } else {
            nuevo.setSiguiente(cabecera);
            cabecera.setAnterior(nuevo);
            cabecera = nuevo;
        }
        return this;
    }
    
    public ListaDoble insertar(Integer boleta, String cliente, int codigo, String modelo, String descripcion,
            int cantid, float precioUni, float precioTot) {

        Nodo nuevo = new Nodo(boleta, cliente, codigo, modelo, descripcion, cantid, precioUni, precioTot);
        nuevo.setCliente(cliente);
        if (esVacia()) {
            cabecera = puntero = nuevo;
        } else {
            nuevo.setSiguiente(cabecera);
            cabecera.setAnterior(nuevo);
            cabecera = nuevo;
        }
        return this;
    }

    public void eliminarNodo(int entrada) {
        Nodo actual;
        boolean encontrado = false;
        actual = cabecera;
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.getCodigo() == entrada);
            if (!encontrado) {
                actual = actual.getSiguiente();
            }
        }
        if (actual != null) {
            if (actual == cabecera) {
                cabecera = actual.getSiguiente();
                if (actual.getSiguiente() != null) {
                    //actual.siguiente.anterior = null;
                    actual.getSiguiente().setAnterior(null);
                }
            } else if (actual.getSiguiente() != null) {
                //actual.anterior.siguiente = actual.siguiente;
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                //actual.siguiente.anterior = actual.anterior;
                actual.getSiguiente().setAnterior(actual.getAnterior());
            } else {
                //actual.anterior.siguiente = null;
                actual.getAnterior().setSiguiente(null);
            }
            if (actual == puntero) {
                puntero = actual.getAnterior();
            }
            actual = null;
        }
    }

    public void ordenar() {
        Nodo indice, subindice, indiceMenor;

        for (indice = cabecera; indice != null; indice = indice.getSiguiente()) {
            indiceMenor = indice;
            for (subindice = indice.getSiguiente(); subindice != null; subindice = subindice.getSiguiente()) {
                if (indiceMenor.getCodigo() > subindice.getCodigo()) {
                    indiceMenor = subindice;
                }
            }
            if (indice != indiceMenor) {
                intercambio(indice, indiceMenor);
            }
        }
    }

    public void intercambio(Nodo primero, Nodo segundo) {
        Integer codigo;
        String modelo;
        String descripcion;
        Integer cantidad;
        Float precioUnitario;
        Float precioTotal;

        codigo = primero.getCodigo();
        modelo = (String) primero.getModelo();
        descripcion = (String) primero.getDescripcion();
        cantidad = primero.getCantidad();
        precioUnitario = primero.getPrecioUnitario();
        precioTotal = primero.getPrecioTotal();

        //i.codigo = j.codigo;
        primero.setCodigo(segundo.getCodigo());
        //i.modelo = j.modelo;
        primero.setModelo(segundo.getModelo());
        //i.descripcion = j.descripcion;
        primero.setDescripcion(segundo.getDescripcion());
        //i.cantidad = j.cantidad;
        primero.setCantidad(segundo.getCantidad());
        //i.precioUnitario = j.precioUnitario;
        primero.setPrecioUnitario(segundo.getPrecioUnitario());
        //i.precioTotal = j.precioTotal;
        primero.setPrecioTotal(segundo.getPrecioTotal());

        //j.codigo = codig;
        segundo.setCodigo(codigo);
        //j.modelo = modelo;
        segundo.setModelo(modelo);
        //j.descripcion = descripcion;
        segundo.setDescripcion(descripcion);
        //j.cantidad = cantidad;
        segundo.setCantidad(cantidad);
        //j.precioUnitario = precioUnitario;
        segundo.setPrecioUnitario(precioUnitario);
        //j.precioTotal = precioTotal;
        segundo.setPrecioTotal(precioTotal);
    }

    public String verLista() {
        Nodo nodo;
        nodo = cabecera;
        String cadena = "";
        while (nodo != null) {
            cadena += nodo;
            nodo = nodo.getSiguiente();
        }
        return cadena;
    }
    
    public void setCliente(String cliente){
        cabecera.setCliente(cliente);
    }

}
