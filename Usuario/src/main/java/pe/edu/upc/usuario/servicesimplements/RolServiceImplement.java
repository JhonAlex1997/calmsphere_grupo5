package pe.edu.upc.usuario.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.usuario.entities.Rol;
import pe.edu.upc.usuario.repositories.IRolRepository;
import pe.edu.upc.usuario.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository repository;

    @Override
    public List<Rol> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Rol r) {
        repository.save(r);
    }

    @Override
    public Rol listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Rol r) {
        repository.save(r);
    }

    @Override
    public List<Rol> buscarTipoRol(String tipo) {
        return repository.buscarTipoRol(tipo);
    }
}
