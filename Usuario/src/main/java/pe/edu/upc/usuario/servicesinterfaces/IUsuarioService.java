package pe.edu.upc.usuario.servicesinterfaces;

import pe.edu.upc.usuario.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario u);
    public Usuario listId(int id);
    public void delete(int id);
    public void update(Usuario u);
    public List<Usuario> buscarNombre(String nombre);
}
