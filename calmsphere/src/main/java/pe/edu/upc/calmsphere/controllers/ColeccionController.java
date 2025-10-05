package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.ColeccionDTO;
import pe.edu.upc.calmsphere.dtos.ColeccionDTOInsert;
import pe.edu.upc.calmsphere.dtos.ColeccionDTOList;
import pe.edu.upc.calmsphere.entities.Coleccion;
import pe.edu.upc.calmsphere.servicesinterfaces.IColeccionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colecciones")
public class ColeccionController {

    @Autowired
    private IColeccionService service;

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Coleccion> lista = service.list();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron colecciones");
        }
        List<ColeccionDTOList> listaDTO = lista.stream()
                .map(c -> new ModelMapper().map(c, ColeccionDTOList.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") int id) {
        Coleccion c = service.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una colección con el ID: " + id);
        }
        ColeccionDTOList dto = new ModelMapper().map(c, ColeccionDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ColeccionDTOInsert dto) {
        Coleccion c = new ModelMapper().map(dto, Coleccion.class);
        service.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Colección registrada con ID: " + c.getIdColeccion());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody ColeccionDTO dto) {
        Coleccion c = new ModelMapper().map(dto, Coleccion.class);
        Coleccion existente = service.listId(c.getIdColeccion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una colección con el ID: " + c.getIdColeccion());
        }
        service.update(c);
        return ResponseEntity.ok("Colección actualizada con ID: " + c.getIdColeccion());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Coleccion c = service.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una colección con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Colección eliminada con ID: " + id);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/busquedas")
    public ResponseEntity<?> buscar(@RequestParam("n") String nombre) {
        List<Coleccion> lista = service.findByNombre(nombre);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron colecciones con el nombre: " + nombre);
        }
        List<ColeccionDTOList> listaDTO = lista.stream()
                .map(c -> new ModelMapper().map(c, ColeccionDTOList.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
