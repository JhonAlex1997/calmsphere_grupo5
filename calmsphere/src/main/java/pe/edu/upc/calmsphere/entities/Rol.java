package pe.edu.upc.calmsphere.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "tipoRol", length = 50, nullable = false)
    private String tipoRol;
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario idUsuario;

    public Rol() {
    }

    public Rol(int idRol, String tipoRol, Usuario idUsuario) {
        this.idRol = idRol;
        this.tipoRol = tipoRol;
        this.idUsuario = idUsuario;
    }

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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}