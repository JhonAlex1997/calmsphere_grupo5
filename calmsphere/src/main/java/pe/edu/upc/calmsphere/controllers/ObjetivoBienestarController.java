package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.ObjetivoBienestarDTO;
import pe.edu.upc.calmsphere.entities.ObjetivoBienestar;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.servicesinterfaces.IObjetivoBienestarService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoBienestarController {
    @Autowired
    private IObjetivoBienestarService service;

    @Autowired
    private IUsuarioService uservice;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<ObjetivoBienestar> objetivos = service.list();

        if (objetivos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron objetivos registrados de los usuarios.");
        }

        List<ObjetivoBienestarDTO> listaDTO = objetivos.stream().map(o->{
            ModelMapper m = new ModelMapper();
            return m.map(o, ObjetivoBienestarDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody ObjetivoBienestarDTO dto) {
        int id = dto.getIdUsuario().getIdUsuario();
        Usuario us = uservice.listId(id);
        if (us == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ObjetivoBienestar o = m.map(dto, ObjetivoBienestar.class);
        service.insert(o);
        return ResponseEntity.ok("El objetivo con ID " + o.getIdObjetivo() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        ObjetivoBienestar o = service.listId(id);
        if (o == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un objetivo con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ObjetivoBienestarDTO dto = m.map(o, ObjetivoBienestarDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ObjetivoBienestar o = service.listId(id);
        if (o == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un objetivo con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El objetivo con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody ObjetivoBienestarDTO dto) {
        ModelMapper m = new ModelMapper();
        ObjetivoBienestar o = m.map(dto, ObjetivoBienestar.class);

        ObjetivoBienestar existente = service.listId(o.getIdObjetivo());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un objetivo con el ID: " + o.getIdObjetivo());
        }

        service.update(o);
        return ResponseEntity.ok("El objetivo con ID " + o.getIdObjetivo() + " fue modificado correctamente.");
    }
}