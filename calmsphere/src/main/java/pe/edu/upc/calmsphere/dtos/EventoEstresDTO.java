package pe.edu.upc.calmsphere.dtos;
import pe.edu.upc.calmsphere.entities.Usuario;

import java.time.LocalDate;

public class EventoEstresDTO {
    private int idEventoEstres;
    private LocalDate fecha;
    private int nivelEstres;
    private String descripcion;
    private UsuarioDTOList idUsuario;

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

    public UsuarioDTOList getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTOList idUsuario) {
        this.idUsuario = idUsuario;
    }
}
