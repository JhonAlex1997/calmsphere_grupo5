package pe.edu.upc.metodopago.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.metodopago.entities.metodopago;
import pe.edu.upc.metodopago.respositories.Imetodopagorepository;
import pe.edu.upc.metodopago.servicesinterfaces.Imetodopagoservice;

import java.util.List;
@Service
public class metodopagoserviceimplement implements Imetodopagoservice {
    @Autowired
    private Imetodopagorepository rM;
    @Override
    public List<metodopago> list() {
        return rM.findAll();
    }
}
