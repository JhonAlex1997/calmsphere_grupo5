package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "duracion", nullable = false)
    private double duracion;

    @Column(name = "intensidad", nullable = false)
    private String intensidad;

    @Column(name = "Observacion", nullable = false)
    private String Observacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idEjercicio")
    private Ejercicio idEjercicio;

    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago idMetodoPago;

    public Actividad() {
    }

    public Actividad(int idActividad, LocalDate fechaRegistro, double duracion, String intensidad, String observacion, Usuario idUsuario, Ejercicio idEjercicio, MetodoPago idMetodoPago) {
        this.idActividad = idActividad;
        this.fechaRegistro = fechaRegistro;
        this.duracion = duracion;
        this.intensidad = intensidad;
        Observacion = observacion;
        this.idUsuario = idUsuario;
        this.idEjercicio = idEjercicio;
        this.idMetodoPago = idMetodoPago;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Ejercicio getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Ejercicio idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public MetodoPago getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(MetodoPago idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
}
