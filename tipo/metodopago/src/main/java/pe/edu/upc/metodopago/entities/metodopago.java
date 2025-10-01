package pe.edu.upc.metodopago.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class metodopago {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idmetodopago;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public metodopago() {
    }

    public metodopago(int idmetodopago, String nombre, String tipo, boolean estado) {
        this.idmetodopago = idmetodopago;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getIdmetodopago() {
        return idmetodopago;
    }

    public void setIdmetodopago(int idmetodopago) {
        this.idmetodopago = idmetodopago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
