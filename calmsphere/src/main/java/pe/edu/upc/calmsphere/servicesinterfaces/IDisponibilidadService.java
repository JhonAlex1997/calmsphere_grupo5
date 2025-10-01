package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.Disponibilidad;

import java.util.List;

public interface IDisponibilidadService {
    List<Disponibilidad> list();
    void insert(Disponibilidad d);
    void update(Disponibilidad d);
    void delete(int id);
    Disponibilidad listId(int id);

    // Filtro simple visto en clase
    List<Disponibilidad> findByDiaSemana(Integer diaSemana);
}
