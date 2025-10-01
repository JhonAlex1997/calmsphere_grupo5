package pe.edu.upc.calmsphere.dtos;

import java.time.LocalTime;

public class DisponibilidadDTO {
    private Integer disponibilidadId;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(Integer disponibilidadId, Integer diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.disponibilidadId = disponibilidadId;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getDisponibilidadId() {
        return disponibilidadId;
    }

    public void setDisponibilidadId(Integer disponibilidadId) {
        this.disponibilidadId = disponibilidadId;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
