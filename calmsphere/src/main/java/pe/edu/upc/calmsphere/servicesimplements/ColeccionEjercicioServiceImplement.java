package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.ColeccionEjercicio;
import pe.edu.upc.calmsphere.repositories.IColeccionEjercicioRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IColeccionEjercicioService;

import java.util.List;

@Service
public class ColeccionEjercicioServiceImplement implements IColeccionEjercicioService {

    @Autowired
    private IColeccionEjercicioRepository ceR;

    @Override
    public void insert(ColeccionEjercicio ce) {
        ceR.save(ce);
    }

    @Override
    public List<ColeccionEjercicio> list() {
        return ceR.findAll();
    }

    @Override
    public ColeccionEjercicio listId(int id) {
        return ceR.findById(id).orElse(null);
    }

    @Override
    public void update(ColeccionEjercicio ce) {
        ceR.save(ce);
    }

    @Override
    public void delete(int id) {
        ceR.deleteById(id);
    }

    @Override
    public List<ColeccionEjercicio> findByColeccion(int idColeccion) {
        return ceR.findByColeccion_IdColeccion(idColeccion);
    }
}
