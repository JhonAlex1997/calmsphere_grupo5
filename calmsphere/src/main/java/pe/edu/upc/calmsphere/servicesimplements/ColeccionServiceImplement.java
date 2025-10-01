package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Coleccion;
import pe.edu.upc.calmsphere.repositories.IColeccionRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IColeccionService;

import java.util.List;

@Service
public class ColeccionServiceImplement implements IColeccionService {

    @Autowired
    private IColeccionRepository cR;

    @Override
    public void insert(Coleccion c) {
        cR.save(c);
    }

    @Override
    public List<Coleccion> list() {
        return cR.findAll();
    }

    @Override
    public Coleccion listId(int id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public void update(Coleccion c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Coleccion> findByNombre(String nombre) {
        return cR.findByNombreContainingIgnoreCase(nombre);
    }
}
