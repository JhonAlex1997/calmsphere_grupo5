package pe.edu.upc.ejercicio.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.ejercicio.dtos.ejercicioDTO;
import pe.edu.upc.ejercicio.entities.ejercicio;
import pe.edu.upc.ejercicio.servicesinterfaces.Iejercicioservice;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ejercicio")
public class ejerciciocontroller {
    @Autowired
    private Iejercicioservice eS;

    public List<ejercicioDTO> listar(){

        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ejercicioDTO.class);
        }).collect(Collectors.toList());
    }

}
