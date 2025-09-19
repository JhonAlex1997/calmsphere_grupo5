package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario u);
    public Usuario listId(int id);
    public void delete(int id);
    public void update(Usuario u);
    public List<Usuario> buscarNombre(String nombre);
}