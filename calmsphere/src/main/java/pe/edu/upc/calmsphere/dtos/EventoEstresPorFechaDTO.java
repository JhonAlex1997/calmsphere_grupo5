package pe.edu.upc.calmsphere.dtos;

import java.time.LocalDate;

public class EventoEstresPorFechaDTO {
    private String Nombre;
    private LocalDate Fecha;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }
}
