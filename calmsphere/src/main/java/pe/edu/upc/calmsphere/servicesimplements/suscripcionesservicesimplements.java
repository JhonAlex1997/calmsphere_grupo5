package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.suscripciones;
import pe.edu.upc.calmsphere.repositories.Isuscripcionesrepository;
import pe.edu.upc.calmsphere.servicesinterfaces.Isuscripcionesservices;

import java.util.List;
@Service
public class suscripcionesservicesimplements implements Isuscripcionesservices {
    @Autowired
    private Isuscripcionesrepository sR;

    @Override
    public List<suscripciones> list() {
        return sR.findAll();
    }
}
