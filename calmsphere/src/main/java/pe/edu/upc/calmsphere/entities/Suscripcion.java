package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

@Entity

public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuscripcion;
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "deracion", nullable = false)
    private double deracion;
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    public Suscripcion() {
    }

    public Suscripcion(int idSuscripcion, String nombre, double precio, double deracion, String descripcion) {
        this.idSuscripcion = idSuscripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.deracion = deracion;
        this.descripcion = descripcion;
    }

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
