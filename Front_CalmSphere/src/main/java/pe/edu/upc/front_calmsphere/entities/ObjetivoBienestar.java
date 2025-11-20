package pe.edu.upc.front_calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "ObjetivoBienestar")
public class ObjetivoBienestar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObjetivo;
    @Column(name = "nombreObjetivo", length = 60, nullable = false)
    private String nombreObjetivo;
    @Column(name = "metaValor", nullable = false)
    private double metaValor;
    @Column(name = "unidad", length = 15, nullable = false)
    private String unidad;
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fechaFin", nullable = false)
    private LocalDate fechaFin;
    @Column(name = "progresoActual", nullable = false)
    private double progresoActual;
    @Column(name = "estado", length = 20, nullable = false)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public ObjetivoBienestar() {
    }

    public ObjetivoBienestar(int idObjetivo, String nombreObjetivo, double metaValor, String unidad, LocalDate fechaInicio, LocalDate fechaFin, double progresoActual, String estado, Usuario idUsuario) {
        this.idObjetivo = idObjetivo;
        this.nombreObjetivo = nombreObjetivo;
        this.metaValor = metaValor;
        this.unidad = unidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.progresoActual = progresoActual;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
