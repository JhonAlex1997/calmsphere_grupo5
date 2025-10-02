package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.ProfesionalServicio;
import pe.edu.upc.calmsphere.repositories.IProfesionalServicioRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IProfesionalServicioService;

import java.util.List;

@Service
public class ProfesionalServicioServiceImplement implements IProfesionalServicioService {

    @Autowired
    private IProfesionalServicioRepository psR;

    @Override
    public void insert(ProfesionalServicio ps) {
        psR.save(ps);
    }

    @Override
    public List<ProfesionalServicio> list() {
        return psR.findAll();
    }

    @Override
    public ProfesionalServicio listId(int id) {
        return psR.findById(id).orElse(null);
    }

    @Override
    public void update(ProfesionalServicio ps) {
        psR.save(ps);
    }

    @Override
    public void delete(int id) {
        psR.deleteById(id);
    }

    @Override
    public List<ProfesionalServicio> findByUsuario(int idUsuario) {
        return psR.findByUsuario_IdUsuario(idUsuario);
    }
}
