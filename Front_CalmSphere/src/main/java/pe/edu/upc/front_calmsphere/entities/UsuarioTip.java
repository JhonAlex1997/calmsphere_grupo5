package pe.edu.upc.front_calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "UsuarioTip")
public class UsuarioTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioTip;
    @Column(name = "fechaEntrega", nullable = false)
    private LocalDate fechaEntrega;
    @Column(name = "canal", length = 20, nullable = false)
    private String canal;
    @Column(name = "guardado", nullable = false)
    private boolean guardado;
    @Column(name = "util",  nullable = false)
    private boolean util;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idTip")
    private Tip idTip;

    public UsuarioTip() {
    }

    public UsuarioTip(int idUsuarioTip, LocalDate fechaEntrega, String canal, boolean guardado, boolean util, Usuario idUsuario, Tip idTip) {
        this.idUsuarioTip = idUsuarioTip;
        this.fechaEntrega = fechaEntrega;
        this.canal = canal;
        this.guardado = guardado;
        this.util = util;
        this.idUsuario = idUsuario;
        this.idTip = idTip;
    }

    public int getIdUsuarioTip() {
        return idUsuarioTip;
    }

    public void setIdUsuarioTip(int idUsuarioTip) {
        this.idUsuarioTip = idUsuarioTip;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    public boolean isUtil() {
        return util;
    }

    public void setUtil(boolean util) {
        this.util = util;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Tip getIdTip() {
        return idTip;
    }

    public void setIdTip(Tip idTip) {
        this.idTip = idTip;
    }
}
