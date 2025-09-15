package pe.edu.upc.usuario.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Lugar")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLugar;
    @Column(name = "proveedor", length = 20, nullable = false)
    private String proveedor;
    @Column(name = "id_externo", length = 100, nullable = false)
    private String id_externo;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "direccion", length = 200, nullable = false)
    private String direccion;
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;
    @Column(name = "guardaqdo_en", nullable = false)
    private LocalDate guardaqdo_en;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public Lugar() {
    }

    public Lugar(int idLugar, String proveedor, String id_externo, String nombre, String direccion, String descripcion, LocalDate guardaqdo_en, Usuario idUsuario) {
        this.idLugar = idLugar;
        this.proveedor = proveedor;
        this.id_externo = id_externo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.guardaqdo_en = guardaqdo_en;
        this.idUsuario = idUsuario;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getId_externo() {
        return id_externo;
    }

    public void setId_externo(String id_externo) {
        this.id_externo = id_externo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getGuardaqdo_en() {
        return guardaqdo_en;
    }

    public void setGuardaqdo_en(LocalDate guardaqdo_en) {
        this.guardaqdo_en = guardaqdo_en;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}