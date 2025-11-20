package pe.edu.upc.front_calmsphere.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Profesional_servicio")
public class ProfesionalServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesional_servicio")
    private Integer idProfesionalServicio;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "duracion_min", nullable = false)
    private Integer duracionMin;

    @Column(name = "precio_base", nullable = false)
    private Double precioBase;

    @ManyToOne
    @JoinColumn(name = "id_disponibilidad", nullable = false)
    private Disponibilidad disponibilidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public ProfesionalServicio() {
    }

    public ProfesionalServicio(Integer idProfesionalServicio, String nombre, Integer duracionMin, Double precioBase, Disponibilidad disponibilidad, Usuario usuario) {
        this.idProfesionalServicio = idProfesionalServicio;
        this.nombre = nombre;
        this.duracionMin = duracionMin;
        this.precioBase = precioBase;
        this.disponibilidad = disponibilidad;
        this.usuario = usuario;
    }

    public Integer getIdProfesionalServicio() {
        return idProfesionalServicio;
    }

    public void setIdProfesionalServicio(Integer idProfesionalServicio) {
        this.idProfesionalServicio = idProfesionalServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(Integer duracionMin) {
        this.duracionMin = duracionMin;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
