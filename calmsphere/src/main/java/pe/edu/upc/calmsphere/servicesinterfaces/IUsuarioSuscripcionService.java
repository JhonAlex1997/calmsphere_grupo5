package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.UsuarioSuscripcion;

import java.util.List;

public interface IUsuarioSuscripcionService {
    public List<UsuarioSuscripcion> list();
    public void update(UsuarioSuscripcion u);
    public void delete(int id);
    public void insert(UsuarioSuscripcion u);

    UsuarioSuscripcion listId(Integer id);
}
