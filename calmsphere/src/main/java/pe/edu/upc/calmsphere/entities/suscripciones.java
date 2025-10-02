package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "suscripciones")
public class suscripciones {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idsuscripcion;

    @Column(name = "nombresuscrpcion", nullable = false, length = 50)
    private String nombresuscripcion;

    @Column(name = "duracionsuscripcion", nullable = false, length = 50)
    private int duracionsuscripcion;

    @Column(name = "preciosuscripcion", nullable = false)
    private double preciosuscripcion;

    @Column(name = "descripcionsuscripcion", nullable = false, length = 80)
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
