package pe.edu.upc.calmsphere.dtos;

public class EjercicioDTOInsert {
    private int id;
    private String nombre;
    private String autor;
    private int duracionSugerida;
    private String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDuracionSugerida() {
        return duracionSugerida;
    }

    public void setDuracionSugerida(int duracionSugerida) {
        this.duracionSugerida = duracionSugerida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
