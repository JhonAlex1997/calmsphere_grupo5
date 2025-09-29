package pe.edu.upc.tipo.entities;

import jakarta.persistence.*;

@Entity
public class tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipo;

    @Column(name = "fuente", nullable = false, length = 50)
    private String fuente;
    @Column(name = "id_externo", nullable = false, length = 50)
    private String id_externo;
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Column(name = "contenido", nullable = false, length = 50)
    private String contenido;

    public tipo() {
    }

    public tipo(int idtipo, String fuente, String id_externo, String titulo, String contenido) {
        this.idtipo = idtipo;
        this.fuente = fuente;
        this.id_externo = id_externo;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getId_externo() {
        return id_externo;
    }

    public void setId_externo(String id_externo) {
        this.id_externo = id_externo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
