package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.Recordatorio;

import java.util.List;

public interface IRecordatorioService {
    public List<Recordatorio> list();
    public void insert(Recordatorio r);
    public Recordatorio listId(int id);
    public void delete(int id);
    public void update(Recordatorio r);
}
