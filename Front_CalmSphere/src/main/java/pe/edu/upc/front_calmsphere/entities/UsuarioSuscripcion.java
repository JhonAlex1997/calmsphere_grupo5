package pe.edu.upc.front_calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "UsuarioSuscripcion")
public class UsuarioSuscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioSuscripcion;
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fechaFin", nullable = false)

    private LocalDate fechaFin;
    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idSuscripcion")
    private Suscripcion idSuscripcion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago idMetodoPago;

    public UsuarioSuscripcion() {
    }

    public UsuarioSuscripcion(int idUsuarioSuscripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado, Suscripcion idSuscripcion, Usuario idUsuario, MetodoPago idMetodoPago) {
        this.idUsuarioSuscripcion = idUsuarioSuscripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.idSuscripcion = idSuscripcion;
        this.idUsuario = idUsuario;
        this.idMetodoPago = idMetodoPago;
    }

    public int getIdUsuarioSuscripcion() {
        return idUsuarioSuscripcion;
    }

    public void setIdUsuarioSuscripcion(int idUsuarioSuscripcion) {
        this.idUsuarioSuscripcion = idUsuarioSuscripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Suscripcion getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(Suscripcion idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MetodoPago getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(MetodoPago idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
}
