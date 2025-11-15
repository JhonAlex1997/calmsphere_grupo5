package pe.edu.upc.calmsphere.dtos;

import java.time.LocalDate;

public class UsuarioEventoEstresDTO {
    private String Nombre_Usuario;
    private int id_EventoEstres;
    private String descripcion;
    private LocalDate fecha;
    private int nivelEstres;

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        Nombre_Usuario = nombre_Usuario;
    }

    public int getId_EventoEstres() {
        return id_EventoEstres;
    }

    public void setId_EventoEstres(int id_EventoEstres) {
        this.id_EventoEstres = id_EventoEstres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
