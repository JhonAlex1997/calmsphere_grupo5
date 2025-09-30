package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Recordatorio")
public class Recordatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecordatorio;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;
    @Column(name = "fechaProgramada", nullable = false)
    private LocalDate fechaProgramada;
    @Column(name = "estado", length = 12, nullable = false)
    private String estado;

    public Recordatorio() {
    }

    public Recordatorio(int idRecordatorio, Usuario idUsuario, String descripcion, LocalDate fechaProgramada, String estado) {
        this.idRecordatorio = idRecordatorio;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.fechaProgramada = fechaProgramada;
        this.estado = estado;
    }

    public int getIdRecordatorio() {
        return idRecordatorio;
    }

    public void setIdRecordatorio(int idRecordatorio) {
        this.idRecordatorio = idRecordatorio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}