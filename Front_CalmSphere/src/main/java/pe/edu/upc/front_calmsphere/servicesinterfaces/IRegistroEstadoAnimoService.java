package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.RegistroEstadoAnimo;

import java.util.List;

public interface IRegistroEstadoAnimoService {
    public List<RegistroEstadoAnimo> list();
    public void insert(RegistroEstadoAnimo r);
    public RegistroEstadoAnimo listId(int id);
    public void delete(int id);
    public void update(RegistroEstadoAnimo r);
}
