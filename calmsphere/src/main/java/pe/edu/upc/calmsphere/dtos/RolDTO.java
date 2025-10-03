package pe.edu.upc.calmsphere.dtos;

import pe.edu.upc.calmsphere.entities.Usuario;

public class RolDTO {
    private int idRol;
    private String tipoRol;
    private UsuarioDTOList idUsuario;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public UsuarioDTOList getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTOList idUsuario) {
        this.idUsuario = idUsuario;
    }
}