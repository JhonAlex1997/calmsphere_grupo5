package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Suscripcion;
import pe.edu.upc.calmsphere.repositories.ISuscripcionRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.ISuscripcionService;

import java.util.List;
@Service
public class SuscripcionServiceImplement {
    @Autowired
    private ISuscripcionRepository sS;

    public List<Suscripcion> list(){
        return sS.findAll();
    }
}
