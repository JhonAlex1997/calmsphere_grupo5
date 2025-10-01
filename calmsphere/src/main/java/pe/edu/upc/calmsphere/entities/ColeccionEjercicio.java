package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "coleccion_ejercicio")
public class ColeccionEjercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coleccion_ejercicio")
    private Integer idColeccionEjercicio;

    @ManyToOne
    @JoinColumn(name = "id_coleccion", nullable = false)
    private Coleccion coleccion;

    @ManyToOne
    @JoinColumn(name = "id_ejercicio", nullable = false)
    private Ejercicio ejercicio;

    public ColeccionEjercicio() {
    }

    public ColeccionEjercicio(Integer idColeccionEjercicio, Coleccion coleccion, Ejercicio ejercicio) {
        this.idColeccionEjercicio = idColeccionEjercicio;
        this.coleccion = coleccion;
        this.ejercicio = ejercicio;
    }

    public Integer getIdColeccionEjercicio() {
        return idColeccionEjercicio;
    }

    public void setIdColeccionEjercicio(Integer idColeccionEjercicio) {
        this.idColeccionEjercicio = idColeccionEjercicio;
    }

    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}
