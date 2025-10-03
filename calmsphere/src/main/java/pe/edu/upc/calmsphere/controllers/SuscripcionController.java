package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.SuscripcionDTO;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody SuscripcionDTO dto) {
        ModelMapper m = new ModelMapper();
        Suscripcion u = m.map(dto, Suscripcion.class);
        ssS.insert(u);
        return ResponseEntity.ok("El usurio con ID " + u.getIdSuscripcion() + " fue registrado correctamente");
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody SuscripcionDTO dto) {
        ModelMapper m = new ModelMapper();
        Suscripcion u = m.map(dto, Suscripcion.class);

        // Validación de existencia
        Suscripcion existente = ssS.listId(u.getIdSuscripcion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + u.getIdSuscripcion());
        }

        // Actualización si pasa validaciones
        ssS.update(u);
        return ResponseEntity.ok("El usuario con ID " + u.getIdSuscripcion() + " fue modificado correctamente.");
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Suscripcion u = ssS.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ssS.delete(id);
        return ResponseEntity.ok("El usuario con ID " + id + " fue eliminado correctamente.");
    }
}
