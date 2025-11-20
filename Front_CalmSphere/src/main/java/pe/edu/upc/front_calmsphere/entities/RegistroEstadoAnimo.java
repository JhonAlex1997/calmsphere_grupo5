package pe.edu.upc.front_calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "RegistroEstadoAnimo")
public class RegistroEstadoAnimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;
    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;
    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;
    @Column(name = "emocion", length = 30, nullable = false)
    private String emocion;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public RegistroEstadoAnimo() {
    }

    public RegistroEstadoAnimo(int idEstado, LocalDate fechaRegistro, int puntuacion, String emocion, String descripcion, Usuario idUsuario) {
        this.idEstado = idEstado;
        this.fechaRegistro = fechaRegistro;
        this.puntuacion = puntuacion;
        this.emocion = emocion;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
