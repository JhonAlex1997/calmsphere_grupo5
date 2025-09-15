package pe.edu.upc.suscripcion.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.suscripcion.SuscripcionApplication;
import pe.edu.upc.suscripcion.repositories.ISuscripcionRepository;
import pe.edu.upc.suscripcion.servicesinterfaces.IServiceSuscripcion;

import java.util.List;
@Service
public class SuscripcionImplement implements IServiceSuscripcion {
    @Autowired
    private ISuscripcionRepository sS;
    @Override
    public List<SuscripcionApplication> list() {
        return sS.findAll();
    }
}
