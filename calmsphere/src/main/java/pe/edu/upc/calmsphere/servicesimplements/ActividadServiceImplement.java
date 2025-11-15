package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Actividad;
import pe.edu.upc.calmsphere.repositories.IActividadRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IActividadService;

import java.time.LocalDate;
import java.util.List;
@Service
public class ActividadServiceImplement implements IActividadService {
    @Autowired
    private IActividadRepository rA;
    @Override
    public List<Actividad> list() {
        return rA.findAll();
    }

    @Override
    public void insert(Actividad a) {
        rA.save(a);
    }

    @Override
    public Actividad listId(int id) {
        return rA.findById(id).orElse(new Actividad());
    }

    @Override
    public void delete(int id) {
        rA.deleteById(id);
    }

    @Override
    public void update(Actividad a) {

    }

    @Override
    public List<Actividad> findByFechaRegistro(LocalDate FechaInicio) {
        return rA.findByFechaRegistro(FechaInicio);
    }
}
