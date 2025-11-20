package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.ColeccionEjercicio;

import java.util.List;

public interface IColeccionEjercicioService {
    void insert(ColeccionEjercicio ce);
    List<ColeccionEjercicio> list();
    ColeccionEjercicio listId(int id);
    void update(ColeccionEjercicio ce);
    void delete(int id);

    List<ColeccionEjercicio> findByColeccion(int idColeccion);
}
