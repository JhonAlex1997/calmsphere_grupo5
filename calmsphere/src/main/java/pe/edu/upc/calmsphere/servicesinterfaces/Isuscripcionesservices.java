package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.suscripciones;

import java.util.List;

public interface Isuscripcionesservices {
    public List<suscripciones> list();
    public void insert(suscripciones s);
    public void update(suscripciones s);
    public void delete(int id);
    public suscripciones listarid(int id);
}
