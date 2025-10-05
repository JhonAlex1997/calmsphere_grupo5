package pe.edu.upc.calmsphere.dtos;

public class ProfesionalServicioDTOUpdate {
    private int idProfesionalServicio;
    private String nombre;
    private int duracionMin;
    private double precioBase;
    private int idDisponibilidad;
    private int idUsuario;

    public int getIdProfesionalServicio() {
        return idProfesionalServicio;
    }

    public void setIdProfesionalServicio(int idProfesionalServicio) {
        this.idProfesionalServicio = idProfesionalServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
