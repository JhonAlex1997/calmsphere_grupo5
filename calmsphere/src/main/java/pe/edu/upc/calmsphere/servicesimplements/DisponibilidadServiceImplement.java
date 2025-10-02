package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Disponibilidad;
import pe.edu.upc.calmsphere.repositories.IDisponibilidadRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IDisponibilidadService;

import java.util.List;

@Service
public class DisponibilidadServiceImplement implements IDisponibilidadService {

    @Autowired
    private IDisponibilidadRepository dR;

    @Override
    public List<Disponibilidad> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Disponibilidad d) {
        dR.save(d);
    }

    @Override
    public void update(Disponibilidad d) {
        dR.save(d);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }

    @Override
    public Disponibilidad listId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public List<Disponibilidad> findByDiaSemana(Integer diaSemana) {
        return dR.findByDiaSemana(diaSemana);
    }
}
