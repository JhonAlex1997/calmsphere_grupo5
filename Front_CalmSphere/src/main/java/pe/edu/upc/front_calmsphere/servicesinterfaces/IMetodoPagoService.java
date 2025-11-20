package pe.edu.upc.front_calmsphere.servicesinterfaces;

import pe.edu.upc.front_calmsphere.entities.MetodoPago;

import java.util.List;

public interface IMetodoPagoService {
    public List<MetodoPago> list();
    public void insert(MetodoPago m);
    public void update(MetodoPago m);
    public void delete(int id);
    public MetodoPago listId(int id);

}
