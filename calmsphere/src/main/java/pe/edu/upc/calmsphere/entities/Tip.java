package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tip")
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTip;
    @Column(name = "fuente", length = 20, nullable = false)
    private String fuente;
    @Column(name = "idExterno", length = 100, nullable = false)
    private String idExterno;
    @Column(name = "titulo", length = 160, nullable = false)
    private String titulo;
    @Column(name = "contenido", nullable = false)
    private String contenido;

    public Tip() {
    }

    public Tip(int idTip, String fuente, String idExterno, String titulo, String contenido) {
        this.idTip = idTip;
        this.fuente = fuente;
        this.idExterno = idExterno;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getIdTip() {
        return idTip;
    }

    public void setIdTip(int idTip) {
        this.idTip = idTip;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
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
