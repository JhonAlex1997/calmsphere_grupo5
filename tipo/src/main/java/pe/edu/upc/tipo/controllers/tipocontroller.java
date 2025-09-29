package pe.edu.upc.tipo.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.tipo.dtos.tipoDTO;
import pe.edu.upc.tipo.entities.tipo;
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

    public void insertar(@RequestBody tipoDTO ins){
        ModelMapper m = new ModelMapper();
        tipo t = m.map(ins, tipo.class);
        iC.insert(t);
    }
    public void eliminar(int id){
        iC.delete(id);
    }
    public void actualizar(@RequestBody tipoDTO upd){
        ModelMapper m = new ModelMapper();
        tipo t = m.map(upd, tipo.class);
        iC.update(t);
    }
}
