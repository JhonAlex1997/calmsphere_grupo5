package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.ObjetivoBienestar;
import pe.edu.upc.calmsphere.repositories.IObjetivoBienestarRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IObjetivoBienestarService;

import java.util.List;
@Service
public class ObjetivoBienestarServiceImplement implements IObjetivoBienestarService {
    @Autowired
    private IObjetivoBienestarRepository repository;

    @Override
    public List<ObjetivoBienestar> list() {
        return repository.findAll();
    }

    @Override
    public void insert(ObjetivoBienestar o) {
        repository.save(o);
    }

    @Override
    public ObjetivoBienestar listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(ObjetivoBienestar o) {
        repository.save(o);
    }
}
