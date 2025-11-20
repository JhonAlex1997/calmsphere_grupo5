package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.Evento;

import java.util.List;

public interface IEventoService {
    void insert(Evento e);
    List<Evento> list();
    Evento listId(int id);
    void update(Evento e);
    void delete(int id);

    List<Evento> findByUsuario(int idUsuario);
    List<Evento> findByProfesionalServicio(int idProfesionalServicio);
    List<Evento> findByMetodoPago(int idMetodoPago);
}
