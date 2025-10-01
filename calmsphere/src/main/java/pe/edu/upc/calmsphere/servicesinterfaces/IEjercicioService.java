package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.Ejercicio;

import java.util.List;

public interface IEjercicioService {
    void insert(Ejercicio e);
    List<Ejercicio> list();
    Ejercicio listId(int id);
    void update(Ejercicio e);
    void delete(int id);

    List<Ejercicio> findByCategoria(String categoria);
}
