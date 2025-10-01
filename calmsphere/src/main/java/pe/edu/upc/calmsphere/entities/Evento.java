package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private Integer idEvento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "profesional_servicio_id", nullable = false)
    private ProfesionalServicio profesionalServicio;

    @ManyToOne
    @JoinColumn(name = "metodopago_id")
    private MetodoPago metodoPago;

    @Column(name = "inicio", nullable = false)
    private LocalDateTime inicio;

    @Column(name = "fin")
    private LocalDateTime fin;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "motivo", length = 200)
    private String motivo;

    @Column(name = "monto", precision = 10, scale = 2)
    private Double monto;

    public Evento() {
    }

    public Evento(Integer idEvento, Usuario usuario, ProfesionalServicio profesionalServicio, MetodoPago metodoPago, LocalDateTime inicio, LocalDateTime fin, boolean estado, String motivo, Double monto) {
        this.idEvento = idEvento;
        this.usuario = usuario;
        this.profesionalServicio = profesionalServicio;
        this.metodoPago = metodoPago;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = estado;
        this.motivo = motivo;
        this.monto = monto;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ProfesionalServicio getProfesionalServicio() {
        return profesionalServicio;
    }

    public void setProfesionalServicio(ProfesionalServicio profesionalServicio) {
        this.profesionalServicio = profesionalServicio;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
