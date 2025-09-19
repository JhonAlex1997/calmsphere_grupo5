package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/listar")
    public List<suscripcionesDTO> listarSuscripciones() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, suscripcionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping(value = "/insertar")
    public void insertarSuscripcion(@RequestBody suscripcionesDTO s){
        ModelMapper m = new ModelMapper();
        suscripciones s1 = m.map(s, suscripciones.class);
        sS.insert(s1);
    }
    @GetMapping(value = "/buscarid/{id}")
    public suscripcionesDTO buscarid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        suscripcionesDTO s = m.map(sS.listarid(id), suscripcionesDTO.class);
        return s;
    }

    @PostMapping
    public void modificar(@RequestBody suscripcionesDTO s){
        ModelMapper m = new ModelMapper();
        suscripciones a = m.map(s, suscripciones.class);
        sS.update(a);
    }
    @DeleteMapping(value = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id){
        sS.delete(id);
    }


}
