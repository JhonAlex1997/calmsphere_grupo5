package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.EventoEstres;

import java.util.List;

public interface IEventoEstresService {
    public List<EventoEstres> list();
    public void insert(EventoEstres e);
    public EventoEstres listId(int id);
    public void delete(int id);
    public void update(EventoEstres e);
    public List<String[]> buscarPorFecha();
}
