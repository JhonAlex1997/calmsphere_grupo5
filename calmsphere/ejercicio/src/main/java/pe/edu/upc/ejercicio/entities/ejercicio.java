package pe.edu.upc.ejercicio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio")
public class ejercicio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idejercicio;

    @Column(name = "categoria", nullable = false, length = 50)
    private int categoria;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "autor", nullable = false, length = 50)
    private String autor;

    @Column(name = "premnium", nullable = false, length = 50)
    private String premnium;

    @Column(name = "duracion", nullable = false, length = 50)
    private int duracion;

    public ejercicio() {
    }

    public ejercicio(int idejercicio, int categoria, String nombre, String autor, String premnium, int duracion) {
        this.idejercicio = idejercicio;
        this.categoria = categoria;
        this.nombre = nombre;
        this.autor = autor;
        this.premnium = premnium;
        this.duracion = duracion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(int idejercicio) {
        this.idejercicio = idejercicio;
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

    public String getPremnium() {
        return premnium;
    }

    public void setPremnium(String premnium) {
        this.premnium = premnium;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
