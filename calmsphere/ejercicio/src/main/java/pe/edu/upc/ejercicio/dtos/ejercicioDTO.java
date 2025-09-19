package pe.edu.upc.ejercicio.dtos;

public class ejercicioDTO {
    private int idejercicio;
    private String categoriaejercicio;
    private String descripcionejercicio;
    private double precioejercicio;
    private int duracionejercicio;

    public int getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(int idejercicio) {
        this.idejercicio = idejercicio;
    }

    public String getCategoriaejercicio() {
        return categoriaejercicio;
    }

    public void setCategoriaejercicio(String categoriaejercicio) {
        this.categoriaejercicio = categoriaejercicio;
    }

    public double getPrecioejercicio() {
        return precioejercicio;
    }

    public void setPrecioejercicio(double precioejercicio) {
        this.precioejercicio = precioejercicio;
    }

    public String getDescripcionejercicio() {
        return descripcionejercicio;
    }

    public void setDescripcionejercicio(String descripcionejercicio) {
        this.descripcionejercicio = descripcionejercicio;
    }

    public int getDuracionejercicio() {
        return duracionejercicio;
    }

    public void setDuracionejercicio(int duracionejercicio) {
        this.duracionejercicio = duracionejercicio;
    }
}
