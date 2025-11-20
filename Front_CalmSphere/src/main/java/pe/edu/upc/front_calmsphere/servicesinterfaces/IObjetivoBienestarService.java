package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.ObjetivoBienestar;

import java.util.List;

public interface IObjetivoBienestarService {
    public List<ObjetivoBienestar> list();
    public void insert(ObjetivoBienestar o);
    public ObjetivoBienestar listId(int id);
    public void delete(int id);
    public void update(ObjetivoBienestar o);
}