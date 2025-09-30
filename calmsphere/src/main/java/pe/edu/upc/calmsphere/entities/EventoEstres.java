package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EventoEstres")
public class EventoEstres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEventoEstres;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "nivelEstres", nullable = false)
    private int nivelEstres;
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public EventoEstres() {
    }

    public EventoEstres(int idEventoEstres, LocalDate fecha, int nivelEstres, String descripcion, Usuario idUsuario) {
        this.idEventoEstres = idEventoEstres;
        this.fecha = fecha;
        this.nivelEstres = nivelEstres;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }

    public int getIdEventoEstres() {
        return idEventoEstres;
    }

    public void setIdEventoEstres(int idEventoEstres) {
        this.idEventoEstres = idEventoEstres;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}