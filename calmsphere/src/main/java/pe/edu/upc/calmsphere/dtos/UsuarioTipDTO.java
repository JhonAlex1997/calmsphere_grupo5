package pe.edu.upc.calmsphere.dtos;

import pe.edu.upc.calmsphere.entities.Tip;
import pe.edu.upc.calmsphere.entities.Usuario;

import java.time.LocalDate;

public class UsuarioTipDTO {
    private int idUsuarioTip;
    private LocalDate fechaEntrega;
    private String canal;
    private boolean guardado;
    private boolean util;
    private Usuario idUsuario;
    private Tip idTip;

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
