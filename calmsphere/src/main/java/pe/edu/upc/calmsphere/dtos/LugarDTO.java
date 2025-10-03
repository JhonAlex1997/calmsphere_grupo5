package pe.edu.upc.calmsphere.dtos;

import java.time.LocalDate;

public class LugarDTO {
    private int idLugar;
    private String proveedor;
    private String id_externo;
    private String nombre;
    private String direccion;
    private String descripcion;
    private LocalDate guardado_en;
    private UsuarioDTOList idUsuario;

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

    public LocalDate getGuardado_en() {
        return guardado_en;
    }

    public void setGuardado_en(LocalDate guardado_en) {
        this.guardado_en = guardado_en;
    }

    public UsuarioDTOList getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTOList idUsuario) {
        this.idUsuario = idUsuario;
    }
}