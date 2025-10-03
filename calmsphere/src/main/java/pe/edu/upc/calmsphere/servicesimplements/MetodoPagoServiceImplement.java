package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pe.edu.upc.calmsphere.dtos.MetodoPagoDTO;
import pe.edu.upc.calmsphere.entities.MetodoPago;
import pe.edu.upc.calmsphere.repositories.IMetodoPagoRepository;
import pe.edu.upc.calmsphere.servicesinterfaces.IMetodoPagoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class MetodoPagoServiceImplement implements IMetodoPagoService {
    @Autowired
    private IMetodoPagoRepository rMP;
    @Override
    public List<MetodoPago> list(){
        return rMP.findAll();
    }

    @Override
    public void insert(MetodoPago m) {
        rMP.save(m);
    }
    @Override
    public void update(MetodoPago m) {
        rMP.save(m);
    }
    @Override
    public void delete(int id) {
        rMP.deleteById(id);
    }

    @Override
    public MetodoPago listId(int id) {
        return rMP.findById(id).orElse(new MetodoPago());
    }

}
