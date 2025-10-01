package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.ColeccionEjercicio;

import java.util.List;

public interface IColeccionEjercicioService {
    void insert(ColeccionEjercicio ce);
    List<ColeccionEjercicio> list();
    ColeccionEjercicio listId(int id);
    void update(ColeccionEjercicio ce);
    void delete(int id);

    List<ColeccionEjercicio> findByColeccion(int idColeccion);
}
