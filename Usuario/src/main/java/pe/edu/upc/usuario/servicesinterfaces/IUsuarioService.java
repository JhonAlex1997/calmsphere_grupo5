package pe.edu.upc.usuario.servicesinterfaces;

import pe.edu.upc.usuario.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario u);
}
