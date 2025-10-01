package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Evento;
import pe.edu.upc.calmsphere.repositories.IEventoRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IEventoService;

import java.util.List;

@Service
public class EventoServiceImplement implements IEventoService {

    @Autowired
    private IEventoRepository eR;

    @Override
    public void insert(Evento e) {
        eR.save(e);
    }

    @Override
    public List<Evento> list() {
        return eR.findAll();
    }

    @Override
    public Evento listId(int id) {
        return eR.findById(id).orElse(null);
    }

    @Override
    public void update(Evento e) {
        eR.save(e);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public List<Evento> findByUsuario(int idUsuario) {
        return eR.findByUsuario_IdUsuario(idUsuario);
    }

    @Override
    public List<Evento> findByProfesionalServicio(int idProfesionalServicio) {
        return eR.findByProfesionalServicio_IdProfesionalServicio(idProfesionalServicio);
    }

    @Override
    public List<Evento> findByMetodoPago(int idMetodoPago) {
        return eR.findByMetodoPago_Id(idMetodoPago);
    }
}
