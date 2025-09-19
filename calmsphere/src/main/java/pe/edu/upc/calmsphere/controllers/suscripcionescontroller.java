package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.calmsphere.dtos.suscripcionesDTO;
import pe.edu.upc.calmsphere.entities.suscripciones;
import pe.edu.upc.calmsphere.servicesinterfaces.Isuscripcionesservices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suscripcioness")
public class suscripcionescontroller {
    @Autowired
    private Isuscripcionesservices sS;


    public List<suscripcionesDTO> listarSuscripciones() {

        return sS.list().stream().map(x->{
         ModelMapper m = new ModelMapper();
         return m.map(x,suscripcionesDTO.class);
        }).collect(Collectors.toList());
    }

}
