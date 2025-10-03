package pe.edu.upc.calmsphere.dtos;

import pe.edu.upc.calmsphere.entities.MetodoPago;
import pe.edu.upc.calmsphere.entities.Suscripcion;
import pe.edu.upc.calmsphere.entities.Usuario;

import java.time.LocalDate;

public class UsuarioSuscripcionDTO {

    private int idUsuarioSuscripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Suscripcion idSuscripcion;
    private Usuario idUsuario;
    private MetodoPago idMetodoPago;

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
