package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol r);
    public Rol listId(int id);
    public void delete(int id);
    public void update(Rol r);
    public List<Rol> buscarTipoRol(String tipo);
}