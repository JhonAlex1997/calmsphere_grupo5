package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.calmsphere.dtos.MetodoPagoDTO;
import pe.edu.upc.calmsphere.servicesinterfaces.IMetodoPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodopago")
public class MetodoPagoController {

    private IMetodoPagoService cMP;

    public List<MetodoPagoDTO> listarmetodo(){
        return cMP.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

}
