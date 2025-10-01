package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.RegistroEstadoAnimo;
import pe.edu.upc.calmsphere.repositories.IRegistroEstadoAnimoRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IRegistroEstadoAnimoService;

import java.util.List;

@Service
public class RegistroEstadoAnimoServiceImplement implements IRegistroEstadoAnimoService {
    @Autowired
    private IRegistroEstadoAnimoRepository repository;

    @Override
    public List<RegistroEstadoAnimo> list() {
        return repository.findAll();
    }

    @Override
    public void insert(RegistroEstadoAnimo r) {
        repository.save(r);
    }

    @Override
    public RegistroEstadoAnimo listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(RegistroEstadoAnimo r) {
        repository.save(r);
    }
}
