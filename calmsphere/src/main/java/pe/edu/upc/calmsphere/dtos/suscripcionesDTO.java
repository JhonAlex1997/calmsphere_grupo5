package pe.edu.upc.calmsphere.dtos;

public class suscripcionesDTO {
    private int idsuscripcion;
    private String nombresuscripcion;
    private int duracionsuscripcion;
    private double preciosuscripcion;
    private String descripcionsuscripcion;

    public int getIdsuscripcion() {
        return idsuscripcion;
    }

    public void setIdsuscripcion(int idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }

    public String getDescripcionsuscripcion() {
        return descripcionsuscripcion;
    }

    public void setDescripcionsuscripcion(String descripcionsuscripcion) {
        this.descripcionsuscripcion = descripcionsuscripcion;
    }

    public double getPreciosuscripcion() {
        return preciosuscripcion;
    }

    public void setPreciosuscripcion(double preciosuscripcion) {
        this.preciosuscripcion = preciosuscripcion;
    }

    public String getNombresuscripcion() {
        return nombresuscripcion;
    }

    public void setNombresuscripcion(String nombresuscripcion) {
        this.nombresuscripcion = nombresuscripcion;
    }

    public int getDuracionsuscripcion() {
        return duracionsuscripcion;
    }

    public void setDuracionsuscripcion(int duracionsuscripcion) {
        this.duracionsuscripcion = duracionsuscripcion;
    }
}
