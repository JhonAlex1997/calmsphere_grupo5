package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Ejercicio;
import pe.edu.upc.calmsphere.repositories.IEjercicioRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IEjercicioService;

import java.util.List;

@Service
public class EjercicioServiceImplement implements IEjercicioService {

    @Autowired
    private IEjercicioRepository eR;

    @Override
    public void insert(Ejercicio e) {
        eR.save(e);
    }

    @Override
    public List<Ejercicio> list() {
        return eR.findAll();
    }

    @Override
    public Ejercicio listId(int id) {
        return eR.findById(id).orElse(null);
    }

    @Override
    public void update(Ejercicio e) {
        eR.save(e);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public List<Ejercicio> findByCategoria(String categoria) {
        return eR.findByCategoria(categoria);
    }

    @Override
    public List<Ejercicio> findByNombreContiene(String nombre) {
        return eR.buscarPorNombreContiene(nombre);
    }

    @Override
    public List<Ejercicio> buscarPorCategoriaYDuracionMinima(String categoria, int duracionMin) {
        return eR.buscarPorCategoriaYDuracionMinima(categoria, duracionMin);
    }
}
