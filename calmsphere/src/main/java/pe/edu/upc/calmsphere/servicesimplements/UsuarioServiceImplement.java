package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.repositories.IUsuarioRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Usuario u) {
        String contraseñaEncriptada = passwordEncoder.encode(u.getContraseña());
        u.setContraseña(contraseñaEncriptada);
        repository.save(u);
    }

    @Override
    public Usuario listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Usuario u) {
        repository.save(u);
    }

    @Override
    public List<Usuario> buscarNombre(String nombre) {
        return repository.buscar(nombre);
    }

    @Override
    public List<String[]> buscarEventoEstresPorUsuario() {
        return repository.buscarEventoEstresPorUsuario();
    }
}