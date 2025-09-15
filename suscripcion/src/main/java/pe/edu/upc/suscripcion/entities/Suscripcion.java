package pe.edu.upc.suscripcion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Suscripcion")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuscripcion;

    @Column(name = "nombre", nullable = false,length = 50)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Column(name = "descripcion", nullable = false,length = 50)
    private String descripcion;

    public Suscripcion() {
    }

    public Suscripcion(int idSuscripcion, String nombre, double precio, int duracion, String descripcion) {
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
