package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.MetodoPagoDTO;
import pe.edu.upc.calmsphere.entities.MetodoPago;
import pe.edu.upc.calmsphere.servicesinterfaces.IMetodoPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodopago")
public class MetodoPagoController {
    @Autowired
    private IMetodoPagoService cMP;

    @GetMapping
    public List<MetodoPagoDTO> listarmetodo(){
        return cMP.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar (@RequestBody MetodoPagoDTO dto){
        ModelMapper m = new ModelMapper();
        MetodoPago mP = m.map(dto, MetodoPago.class);
        cMP.insert(mP);
    }
    @PutMapping
    public void actualizar (@RequestBody MetodoPagoDTO dto){
        ModelMapper m = new ModelMapper();
        MetodoPago mP = m.map(dto, MetodoPago.class);
        cMP.update(mP);
    }
    @DeleteMapping("/{id}")
    public void eliminar ( @PathVariable ("id")int id){
        cMP.delete(id);
    }
    @GetMapping("/{id}")
    public MetodoPagoDTO listId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        MetodoPagoDTO dto = m.map(cMP.listId(id), MetodoPagoDTO.class);
        return dto;
    }

}
