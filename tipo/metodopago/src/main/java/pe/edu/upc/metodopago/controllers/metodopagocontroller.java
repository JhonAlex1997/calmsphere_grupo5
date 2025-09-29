package pe.edu.upc.metodopago.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.metodopago.dtos.metodopagoDTO;
import pe.edu.upc.metodopago.entities.metodopago;
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

    @PostMapping
    public void insertar(@RequestBody metodopagoDTO ins){
        ModelMapper m = new ModelMapper();
        metodopago t = m.map(ins, metodopago.class);
        mS.insert(t);
    }
    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable("id")int id){
        mS.delete(id);
    }
    @PutMapping
    public void actualizar(@RequestBody metodopagoDTO upd){
        ModelMapper m = new ModelMapper();
        metodopago t = m.map(upd, metodopago.class);
        mS.update(t);
    }
}
