package pe.edu.upc.calmsphere.dtos;

import java.time.LocalDateTime;

public class EventoDTOInsert {
    private int idEvento;
    private int idUsuario;
    private int idProfesionalServicio;
    private int idMetodoPago;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private boolean estado;
    private String motivo;
    private Double monto;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProfesionalServicio() {
        return idProfesionalServicio;
    }

    public void setIdProfesionalServicio(int idProfesionalServicio) {
        this.idProfesionalServicio = idProfesionalServicio;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
