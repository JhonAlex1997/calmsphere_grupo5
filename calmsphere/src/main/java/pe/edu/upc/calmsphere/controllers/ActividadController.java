package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.ActividadDTO;
import pe.edu.upc.calmsphere.dtos.ColeccionDTOInsert;
import pe.edu.upc.calmsphere.dtos.ColeccionDTOList;
import pe.edu.upc.calmsphere.entities.Actividad;
import pe.edu.upc.calmsphere.entities.Coleccion;
import pe.edu.upc.calmsphere.servicesinterfaces.IActividadService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    private IActividadService iAS;

    public ResponseEntity<?> listar() {
        List<Actividad> list = iAS.list();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron colecciones");
        }
        List<ActividadDTO> listaDTO = list.stream()
                .map(c -> new ModelMapper().map(c, ActividadDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") int id) {
        Actividad c = iAS.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una colección con el ID: " + id);
        }
        ActividadDTO dto = new ModelMapper().map(c, ActividadDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ActividadDTO dto) {
        Actividad c = new ModelMapper().map(dto, Actividad.class);
        iAS.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Colección registrada con ID: " + c.getIdActividad());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody ActividadDTO dto) {
        Actividad c = new ModelMapper().map(dto, Actividad.class);
        Actividad existente = iAS.listId(c.getIdActividad());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una colección con el ID: " + c.getIdActividad());
        }
        iAS.update(c);
        return ResponseEntity.ok("Colección actualizada con ID: " + c.getIdActividad());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Actividad c = iAS.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una colección con el ID: " + id);
        }
        iAS.delete(id);
        return ResponseEntity.ok("Colección eliminada con ID: " + id);
    }

}
