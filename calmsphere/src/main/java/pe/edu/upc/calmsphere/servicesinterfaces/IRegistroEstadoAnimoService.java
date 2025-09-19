package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.RegistroEstadoAnimo;

import java.util.List;

public interface IRegistroEstadoAnimoService {
    public List<RegistroEstadoAnimo> list();
    public void insert(RegistroEstadoAnimo r);
    public RegistroEstadoAnimo listId(int id);
    public void delete(int id);
    public void update(RegistroEstadoAnimo r);
}
