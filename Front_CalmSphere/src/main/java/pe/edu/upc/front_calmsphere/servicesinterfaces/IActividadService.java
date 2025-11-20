package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.Actividad;

import java.time.LocalDate;
import java.util.List;

public interface IActividadService {
    public List<Actividad> list();
    public void insert(Actividad a);
    public Actividad listId(int id);
    public void delete(int id);
    public void update(Actividad a);

    public List<Actividad> findByFechaRegistro (LocalDate FechaInicio);

}
