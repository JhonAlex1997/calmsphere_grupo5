package pe.edu.upc.tipo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tipo.entities.tipo;
import pe.edu.upc.tipo.repositories.Itiporepository;
import pe.edu.upc.tipo.servicesinterfaces.Itiposervice;

import java.util.List;
@Service
public class tiposerviceimplement implements Itiposervice {
    @Autowired
    private Itiporepository iR;

    @Override
    public List<tipo> list() {
        return iR.findAll();
    }
}
