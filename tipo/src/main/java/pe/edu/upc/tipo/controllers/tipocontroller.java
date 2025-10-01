package pe.edu.upc.tipo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.tipo.dtos.tipoDTO;
import pe.edu.upc.tipo.servicesinterfaces.Itiposervice;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo")
public class tipocontroller {
    @Autowired
    private Itiposervice iC;
    @GetMapping
    public List<tipoDTO> list(){
        return iC.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, tipoDTO.class);
        }).collect(Collectors.toList());
    }
}
