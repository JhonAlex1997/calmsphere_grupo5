package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.Tip;

import java.util.List;

public interface ITipService {
    public List<Tip> list();
    public void insert(Tip t);
    public Tip listId(int id);
    public void delete(int id);
    public void update(Tip t);
}
