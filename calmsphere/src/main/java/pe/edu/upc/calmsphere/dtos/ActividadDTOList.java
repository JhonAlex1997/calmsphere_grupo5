package pe.edu.upc.calmsphere.dtos;

public class ActividadDTOList {
    private int idActividad;
    private String fechaRegistro;
    private double duracion;
    private String intensidad;
    private String Observacion;
    private UsuarioDTOList idUsuario;
    private EjercicioDTOList idEjercicio;
    private MetodoPagoDTOList idMetodoPago;

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public UsuarioDTOList getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTOList idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EjercicioDTOList getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(EjercicioDTOList idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public MetodoPagoDTOList getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(MetodoPagoDTOList idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
}
