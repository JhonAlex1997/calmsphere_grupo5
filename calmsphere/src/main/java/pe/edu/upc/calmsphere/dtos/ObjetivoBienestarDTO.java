package pe.edu.upc.calmsphere.dtos;
import pe.edu.upc.calmsphere.entities.Usuario;

import java.time.LocalDate;

public class ObjetivoBienestarDTO {
    private int idObjetivo;
    private String nombreObjetivo;
    private double metaValor;
    private String unidad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double progresoActual;
    private String estado;
    private UsuarioDTOList idUsuario;

    public int getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(int idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getNombreObjetivo() {
        return nombreObjetivo;
    }

    public void setNombreObjetivo(String nombreObjetivo) {
        this.nombreObjetivo = nombreObjetivo;
    }

    public double getMetaValor() {
        return metaValor;
    }

    public void setMetaValor(double metaValor) {
        this.metaValor = metaValor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
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

    public double getProgresoActual() {
        return progresoActual;
    }

    public void setProgresoActual(double progresoActual) {
        this.progresoActual = progresoActual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioDTOList getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTOList idUsuario) {
        this.idUsuario = idUsuario;
    }
}