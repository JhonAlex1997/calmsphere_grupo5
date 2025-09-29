package pe.edu.upc.metodopago.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.metodopago.dtos.metodopagoDTO;
import pe.edu.upc.metodopago.servicesinterfaces.Imetodopagoservice;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodopago")
public class metodopagocontroller {
    @Autowired
    private Imetodopagoservice mS;
    @GetMapping
    public List<metodopagoDTO> list(){
        return mS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, metodopagoDTO.class);
        }).collect(Collectors.toList());
    }
}
