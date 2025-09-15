package pe.edu.upc.suscripcion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.suscripcion.SuscripcionApplication;
import pe.edu.upc.suscripcion.servicesinterfaces.IServiceSuscripcion;

import java.util.List;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {
    @Autowired
    private IServiceSuscripcion sS;

    public List<SuscripcionApplication> list(){

        return sS.list();
    }
}
