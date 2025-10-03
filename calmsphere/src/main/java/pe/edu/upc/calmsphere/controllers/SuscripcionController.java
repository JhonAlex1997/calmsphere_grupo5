package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.MetodoPagoDTO;
import pe.edu.upc.calmsphere.dtos.SuscripcionDTO;
import pe.edu.upc.calmsphere.entities.MetodoPago;
import pe.edu.upc.calmsphere.entities.Suscripcion;
import pe.edu.upc.calmsphere.servicesinterfaces.ISuscripcionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suscripcion")
public class SuscripcionController {
    @Autowired
    private ISuscripcionService ssS;
    @GetMapping
    public List<SuscripcionDTO> listarSuscripcion(){
        return ssS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SuscripcionDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar (@RequestBody SuscripcionDTO dto){
        ModelMapper m = new ModelMapper();
        Suscripcion mP = m.map(dto,Suscripcion.class);
        ssS.insert(mP);
    }
    @PutMapping
    public void actualizar (@RequestBody SuscripcionDTO dto){
        ModelMapper m = new ModelMapper();
        Suscripcion mP = m.map(dto, Suscripcion.class);
        ssS.update(mP);
    }
    @DeleteMapping("/{id}")
    public void eliminar ( @PathVariable ("id")int id){
        ssS.delete(id);
    }

    @GetMapping("/{id}")
    public SuscripcionDTO listId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        SuscripcionDTO dto = m.map(ssS.listId(id), SuscripcionDTO.class);
        return dto;
    }
}
