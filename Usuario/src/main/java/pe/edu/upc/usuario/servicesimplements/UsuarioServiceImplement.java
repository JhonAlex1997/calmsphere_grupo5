package pe.edu.upc.usuario.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.usuario.entities.Usuario;
import pe.edu.upc.usuario.repositories.IUsuarioRepository;
import pe.edu.upc.usuario.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository repository;

    @Override
    public List<Usuario> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Usuario u) {
        repository.save(u);
    }
}
