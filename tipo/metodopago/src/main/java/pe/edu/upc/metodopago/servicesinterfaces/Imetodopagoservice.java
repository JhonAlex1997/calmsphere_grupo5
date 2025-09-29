package pe.edu.upc.metodopago.servicesinterfaces;

import pe.edu.upc.metodopago.entities.metodopago;

import java.util.List;

public interface Imetodopagoservice {
    public List<metodopago> list();
    public void insert(metodopago t);
    public void delete(int id);
    public void update(metodopago t);
    public metodopago getById(int id);
}
