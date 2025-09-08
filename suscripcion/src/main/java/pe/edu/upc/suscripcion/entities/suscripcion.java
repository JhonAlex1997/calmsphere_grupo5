package pe.edu.upc.suscripcion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "suscripcion")
public class suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuscripcion;
    private String nombre;
    private double precio;
    private int duracion;
    private String descripcion;

    public suscripcion() {
    }

    public suscripcion(int idSuscripcion, String nombre, double precio, int duracion, String descripcion) {
        this.idSuscripcion = idSuscripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
