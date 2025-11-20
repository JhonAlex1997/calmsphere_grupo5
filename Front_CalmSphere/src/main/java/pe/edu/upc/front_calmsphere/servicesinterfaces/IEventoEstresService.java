package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.EventoEstres;

import java.util.List;

public interface IEventoEstresService {
    public List<EventoEstres> list();
    public void insert(EventoEstres e);
    public EventoEstres listId(int id);
    public void delete(int id);
    public void update(EventoEstres e);
    public List<String[]> buscarPorFecha();
}
