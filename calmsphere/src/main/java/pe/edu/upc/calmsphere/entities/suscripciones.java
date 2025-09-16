package pe.edu.upc.calmsphere.entities;

public class suscripciones {
    private int idsuscripcion;
    private String nombresuscripcion;
    private int duracionsuscripcion;
    private double preciosuscripcion;
    private String descripcionsuscripcion;

    public suscripciones() {
    }

    public suscripciones(int idsuscripcion, String nombresuscripcion, int duracionsuscripcion, double preciosuscripcion, String descripcionsuscripcion) {
        this.idsuscripcion = idsuscripcion;
        this.nombresuscripcion = nombresuscripcion;
        this.duracionsuscripcion = duracionsuscripcion;
        this.preciosuscripcion = preciosuscripcion;
        this.descripcionsuscripcion = descripcionsuscripcion;
    }

    public int getIdsuscripcion() {
        return idsuscripcion;
    }

    public void setIdsuscripcion(int idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
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

    public double getPreciosuscripcion() {
        return preciosuscripcion;
    }

    public void setPreciosuscripcion(double preciosuscripcion) {
        this.preciosuscripcion = preciosuscripcion;
    }

    public String getDescripcionsuscripcion() {
        return descripcionsuscripcion;
    }

    public void setDescripcionsuscripcion(String descripcionsuscripcion) {
        this.descripcionsuscripcion = descripcionsuscripcion;
    }
}
