package pe.edu.upc.usuario.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.usuario.entities.Lugar;
import pe.edu.upc.usuario.repositories.ILugarRepository;
import pe.edu.upc.usuario.servicesinterfaces.ILugarService;

import java.util.List;
@Service
public class LugarServiceImplement implements ILugarService {
    @Autowired
    private ILugarRepository repository;

    @Override
    public List<Lugar> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Lugar l) {
        repository.save(l);
    }

    @Override
    public Lugar listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Lugar l) {
        repository.save(l);
    }

    @Override
    public List<Lugar> buscarNombre(String nombre) {
        return repository.buscar(nombre);
    }
}
