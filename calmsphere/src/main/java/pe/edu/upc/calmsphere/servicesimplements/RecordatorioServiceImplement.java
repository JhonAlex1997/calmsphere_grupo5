package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Recordatorio;
import pe.edu.upc.calmsphere.repositories.IRecordatorioRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IRecordatorioService;

import java.util.List;

@Service
public class RecordatorioServiceImplement implements IRecordatorioService {
    @Autowired
    private IRecordatorioRepository repository;

    @Override
    public List<Recordatorio> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Recordatorio r) {
        repository.save(r);
    }

    @Override
    public Recordatorio listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Recordatorio r) {
        repository.save(r);
    }
}
