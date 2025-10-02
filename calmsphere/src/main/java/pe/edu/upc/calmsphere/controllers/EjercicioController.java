package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.EjercicioDTOInsert;
import pe.edu.upc.calmsphere.dtos.EjercicioDTOList;
import pe.edu.upc.calmsphere.entities.Ejercicio;
import pe.edu.upc.calmsphere.servicesinterfaces.IEjercicioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ejercicios")
public class EjercicioController {

    @Autowired
    private IEjercicioService ejercicioService;

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Ejercicio> lista = ejercicioService.list();
        if (lista == null || lista.isEmpty()) {
            return new ResponseEntity<>("No se encontraron ejercicios", HttpStatus.NOT_FOUND);
        }
        List<EjercicioDTOList> listaDTO = lista.stream()
                .map(e -> new ModelMapper().map(e, EjercicioDTOList.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(listaDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") int id) {
        Ejercicio ejercicio = ejercicioService.listId(id);
        if (ejercicio == null) {
            return new ResponseEntity<>("No se encontró el ejercicio", HttpStatus.NOT_FOUND);
        }
        EjercicioDTOList dto = new ModelMapper().map(ejercicio, EjercicioDTOList.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PostMapping
    public ResponseEntity<?> insertar(@RequestBody EjercicioDTOInsert dto) {
        Ejercicio ejercicio = new ModelMapper().map(dto, Ejercicio.class);
        ejercicioService.insert(ejercicio);
        return new ResponseEntity<>("Ejercicio registrado con ID: " + ejercicio.getId(), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody EjercicioDTOInsert dto) {
        Ejercicio ejercicio = new ModelMapper().map(dto, Ejercicio.class);
        Ejercicio existente = ejercicioService.listId(ejercicio.getId());
        if (existente == null) {
            return new ResponseEntity<>("No se encontró el ejercicio para actualizar", HttpStatus.NOT_FOUND);
        }
        ejercicioService.update(ejercicio);
        return new ResponseEntity<>("Ejercicio actualizado correctamente con ID: " + ejercicio.getId(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") int id) {
        Ejercicio ejercicio = ejercicioService.listId(id);
        if (ejercicio == null) {
            return new ResponseEntity<>("No se encontró el ejercicio para eliminar", HttpStatus.NOT_FOUND);
        }
        ejercicioService.delete(id);
        return new ResponseEntity<>("Ejercicio eliminado correctamente", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/busquedas")
    public ResponseEntity<?> buscar(@RequestParam("c") String categoria) {
        List<Ejercicio> lista = ejercicioService.findByCategoria(categoria);
        if (lista == null || lista.isEmpty()) {
            return new ResponseEntity<>("No se encontraron ejercicios para la categoría indicada", HttpStatus.NOT_FOUND);
        }
        List<EjercicioDTOList> listaDTO = lista.stream()
                .map(e -> new ModelMapper().map(e, EjercicioDTOList.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(listaDTO, HttpStatus.OK);
    }
}
