package pe.edu.upc.tipo.servicesinterfaces;

import pe.edu.upc.tipo.entities.tipo;

import java.util.List;

public interface Itiposervice {

    public List<tipo> list();
    public void insert(tipo t);
    public void delete(int id);
    public void update(tipo t);
}
