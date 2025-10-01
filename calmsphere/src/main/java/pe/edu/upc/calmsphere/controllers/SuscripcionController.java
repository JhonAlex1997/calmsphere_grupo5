package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.calmsphere.dtos.SuscripcionDTO;
import pe.edu.upc.calmsphere.servicesinterfaces.ISuscripcionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suscripcion")
public class SuscripcionController {

    private ISuscripcionService sS;
    @GetMapping
    public List<SuscripcionDTO> listarSuscripcion(){
        return sS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, SuscripcionDTO.class);
        }).collect(Collectors.toList());
    }
}
