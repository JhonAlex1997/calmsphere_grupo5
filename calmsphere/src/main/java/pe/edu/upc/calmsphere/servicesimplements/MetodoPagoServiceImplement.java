package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.MetodoPago;
import pe.edu.upc.calmsphere.repositories.IMetodoPagoRepository;

import java.util.List;

@Service
public class MetodoPagoServiceImplement {
    @Autowired
    private IMetodoPagoRepository rMP;

    public List<MetodoPago> list(){
        return rMP.findAll();
    }
}
