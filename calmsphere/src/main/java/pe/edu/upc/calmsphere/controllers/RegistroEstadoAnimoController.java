package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.RegistroEstadoAnimoDTO;
import pe.edu.upc.calmsphere.entities.RegistroEstadoAnimo;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.servicesinterfaces.IRegistroEstadoAnimoService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados")
public class RegistroEstadoAnimoController {
    @Autowired
    private IRegistroEstadoAnimoService service;

    @Autowired
    private IUsuarioService uservice;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<RegistroEstadoAnimo> estados = service.list();

        if (estados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron estados de ánimo registrados de los usuarios.");
        }

        List<RegistroEstadoAnimoDTO> listaDTO = estados.stream().map(e->{
            ModelMapper m = new ModelMapper();
            return m.map(e, RegistroEstadoAnimoDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody RegistroEstadoAnimoDTO dto) {
        int id = dto.getIdUsuario().getIdUsuario();
        Usuario us = uservice.listId(id);
        if (us == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RegistroEstadoAnimo e = m.map(dto, RegistroEstadoAnimo.class);
        service.insert(e);
        return ResponseEntity.ok("El estado de ánimo con ID " + e.getIdEstado() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        RegistroEstadoAnimo e = service.listId(id);
        if (e == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un estado de ánimo registrado con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RegistroEstadoAnimoDTO dto = m.map(e, RegistroEstadoAnimoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        RegistroEstadoAnimo e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un estado de ánimo registrado con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El estado de ánimo con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody RegistroEstadoAnimoDTO dto) {
        ModelMapper m = new ModelMapper();
        RegistroEstadoAnimo e = m.map(dto, RegistroEstadoAnimo.class);

        RegistroEstadoAnimo existente = service.listId(e.getIdEstado());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un estado de ánimo registrado con el ID: " + e.getIdEstado());
        }

        service.update(e);
        return ResponseEntity.ok("El estado de ánimo con ID " + e.getIdEstado() + " fue modificado correctamente.");
    }
}