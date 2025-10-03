package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvento;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "profesionalServicio")
    private ProfesionalServicio profesionalServicio;
    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago idMetodoPago;
    @Column(name = "inicio", nullable = false)
    private LocalDateTime inicio;
    @Column(name = "fin", nullable = false)
    private LocalDateTime fin;
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @Column(name = "motivo", nullable = false)
    private String motivo;
    @Column(name = "monto", nullable = false)
    private double monto;

    public Evento() {
    }

    public Evento(int idEvento, Usuario idUsuario, ProfesionalServicio profesionalServicio, MetodoPago idMetodoPago, LocalDateTime inicio, LocalDateTime fin, boolean estado, String motivo, double monto) {
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
        this.profesionalServicio = profesionalServicio;
        this.idMetodoPago = idMetodoPago;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = estado;
        this.motivo = motivo;
        this.monto = monto;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ProfesionalServicio getProfesionalServicio() {
        return profesionalServicio;
    }

    public void setProfesionalServicio(ProfesionalServicio profesionalServicio) {
        this.profesionalServicio = profesionalServicio;
    }

    public MetodoPago getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(MetodoPago idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
