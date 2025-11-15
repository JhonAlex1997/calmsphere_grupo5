package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.Suscripcion;

import java.util.List;

public interface ISuscripcionService {
    public List<Suscripcion> list();
    public void insert(Suscripcion s);
    public Suscripcion listId(int id);
    public void delete(int id);
    public void update(Suscripcion s);
}
