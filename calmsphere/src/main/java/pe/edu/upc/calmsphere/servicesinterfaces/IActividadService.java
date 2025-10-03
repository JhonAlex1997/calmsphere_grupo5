package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.Actividad;

import java.util.List;

public interface IActividadService {
    public List<Actividad> list();
    public void insert(Actividad a);
    public Actividad listId(int id);
    public void delete(int id);
    public void update(Actividad a);
}
