package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.Coleccion;

import java.util.List;

public interface IColeccionService {
    void insert(Coleccion c);
    List<Coleccion> list();
    Coleccion listId(int id);
    void update(Coleccion c);
    void delete(int id);

    List<Coleccion> findByNombre(String nombre);
}
