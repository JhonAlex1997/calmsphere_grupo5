package pe.edu.upc.ejercicio.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ejercicio.entities.ejercicio;
import pe.edu.upc.ejercicio.repositories.Iejerciciorepository;
import pe.edu.upc.ejercicio.servicesinterfaces.Iejercicioservice;

import java.util.List;
@Service
public class ejercicioserviceimplement implements Iejercicioservice {
    @Autowired
    private Iejerciciorepository iej;

    @Override
    public List<ejercicio> list() {
        return iej.findAll();
    }
}
