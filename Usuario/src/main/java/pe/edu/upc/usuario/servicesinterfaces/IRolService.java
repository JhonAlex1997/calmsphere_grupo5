package pe.edu.upc.usuario.servicesinterfaces;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.usuario.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol r);
    public Rol listId(int id);
    public void delete(int id);
    public void update(Rol r);
    public List<Rol> buscarTipoRol(String tipo);
}
