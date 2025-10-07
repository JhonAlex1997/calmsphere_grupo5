package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.UsuarioSuscripcion;
import pe.edu.upc.calmsphere.repositories.IUsuarioSuscripcionRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioSuscripcionService;

import java.util.List;
@Service
public class UsuarioSuscripcionServiceImplement implements IUsuarioSuscripcionService {
    @Autowired
    private IUsuarioSuscripcionRepository iUS;

    @Override
    public List<UsuarioSuscripcion> list() {
        return iUS.findAll();
    }

    @Override
    public void update(UsuarioSuscripcion u) {
        iUS.save(u);
    }

    @Override
    public void delete(int id) {
        iUS.deleteById(id);
    }

    @Override
    public void insert(UsuarioSuscripcion u) {
        iUS.save(u);
    }

}
