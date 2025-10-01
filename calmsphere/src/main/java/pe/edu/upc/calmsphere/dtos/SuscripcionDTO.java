package pe.edu.upc.calmsphere.dtos;

import jakarta.persistence.Column;

public class SuscripcionDTO {
    private int idSuscripcion;
    private String nombre;
    private double precio;
    private double deracion;
    private String descripcion;

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDeracion() {
        return deracion;
    }

    public void setDeracion(double deracion) {
        this.deracion = deracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
