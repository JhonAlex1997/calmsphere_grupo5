package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "autor", length = 100, nullable = false)
    private String autor;

    @Column(name = "duracion_sugerida", nullable = false)
    private Integer duracionSugerida;

    @Column(name = "categoria", length = 100, nullable = false)
    private String categoria;

    public Ejercicio() {
    }

    public Ejercicio(String nombre, String autor, Integer duracionSugerida, String categoria) {
        this.nombre = nombre;
        this.autor = autor;
        this.duracionSugerida = duracionSugerida;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getDuracionSugerida() {
        return duracionSugerida;
    }

    public void setDuracionSugerida(Integer duracionSugerida) {
        this.duracionSugerida = duracionSugerida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
