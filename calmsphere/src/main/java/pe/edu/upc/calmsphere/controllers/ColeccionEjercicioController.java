package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.ColeccionEjercicioDTOInsert;
import pe.edu.upc.calmsphere.dtos.ColeccionEjercicioDTOList;
import pe.edu.upc.calmsphere.entities.Coleccion;
import pe.edu.upc.calmsphere.entities.ColeccionEjercicio;
import pe.edu.upc.calmsphere.entities.Ejercicio;
import pe.edu.upc.calmsphere.servicesinterfaces.IColeccionEjercicioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coleccion-ejercicios")
public class ColeccionEjercicioController {

    @Autowired
    private IColeccionEjercicioService service;

    private ColeccionEjercicioDTOList toDTO(ColeccionEjercicio ce) {
        ColeccionEjercicioDTOList dto = new ColeccionEjercicioDTOList();
        dto.setIdColeccionEjercicio(ce.getIdColeccionEjercicio());
        dto.setIdColeccion(ce.getColeccion() != null ? ce.getColeccion().getIdColeccion() : 0);
        dto.setIdEjercicio(ce.getEjercicio() != null ? ce.getEjercicio().getId() : 0);
        return dto;
    }

    private ColeccionEjercicio toEntity(ColeccionEjercicioDTOInsert dto) {
        ColeccionEjercicio ce = new ColeccionEjercicio();
        ce.setIdColeccionEjercicio(dto.getIdColeccionEjercicio());
        Coleccion c = new Coleccion();
        c.setIdColeccion(dto.getIdColeccion());
        Ejercicio e = new Ejercicio();
        e.setId(dto.getIdEjercicio());
        ce.setColeccion(c);
        ce.setEjercicio(e);
        return ce;
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ColeccionEjercicio> lista = service.list();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros de coleccion-ejercicio");
        }
        List<ColeccionEjercicioDTOList> listaDTO = lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") int id) {
        ColeccionEjercicio ce = service.listId(id);
        if (ce == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro coleccion-ejercicio con el ID: " + id);
        }
        return ResponseEntity.ok(toDTO(ce));
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ColeccionEjercicioDTOInsert dto) {
        ColeccionEjercicio ce = toEntity(dto);
        service.insert(ce);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registro coleccion-ejercicio creado con ID: " + ce.getIdColeccionEjercicio());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody ColeccionEjercicioDTOInsert dto) {
        ColeccionEjercicio ce = toEntity(dto);
        ColeccionEjercicio existente = service.listId(ce.getIdColeccionEjercicio());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ce.getIdColeccionEjercicio());
        }
        service.update(ce);
        return ResponseEntity.ok("Registro coleccion-ejercicio actualizado con ID: " + ce.getIdColeccionEjercicio());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        ColeccionEjercicio ce = service.listId(id);
        if (ce == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro coleccion-ejercicio con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro coleccion-ejercicio eliminado con ID: " + id);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/busquedas")
    public ResponseEntity<?> buscarPorColeccion(@RequestParam("idColeccion") int idColeccion) {
        List<ColeccionEjercicio> lista = service.findByColeccion(idColeccion);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron ejercicios para la colección con ID: " + idColeccion);
        }
        List<ColeccionEjercicioDTOList> listaDTO = lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
