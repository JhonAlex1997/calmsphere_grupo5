package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.Lugar;

import java.util.List;

public interface ILugarService {
    public List<Lugar> list();
    public void insert(Lugar l);
    public Lugar listId(int id);
    public void delete(int id);
    public void update(Lugar l);
    public List<Lugar> buscarNombre(String nombre);
}