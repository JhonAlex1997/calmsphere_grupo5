package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Actividad;
import pe.edu.upc.calmsphere.repositories.IActividadRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IActividadService;

import java.util.List;
@Service
public class ActividadServiceImplement implements IActividadService {
    @Autowired
    private IActividadRepository iAR;
    @Override
    public List<Actividad> list() {
        return iAR.findAll();
    }
}
