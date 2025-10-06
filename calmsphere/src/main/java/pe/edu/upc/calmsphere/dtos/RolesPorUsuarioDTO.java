package pe.edu.upc.calmsphere.dtos;

public class RolesPorUsuarioDTO {
    private String Nombre;
    private int NroRoles;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getNroRoles() {
        return NroRoles;
    }

    public void setNroRoles(int nroRoles) {
        NroRoles = nroRoles;
    }
}
