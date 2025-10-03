package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Coleccion")
public class Coleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coleccion")
    private Integer idColeccion;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    public Coleccion() {
    }

    public Coleccion(Integer idColeccion, String nombre, String descripcion) {
        this.idColeccion = idColeccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
