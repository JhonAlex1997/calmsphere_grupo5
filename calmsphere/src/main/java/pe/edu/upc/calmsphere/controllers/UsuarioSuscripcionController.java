package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.UsuarioSuscripcionDTO;
import pe.edu.upc.calmsphere.entities.UsuarioSuscripcion;
import pe.edu.upc.calmsphere.servicesinterfaces.IMetodoPagoService;
import pe.edu.upc.calmsphere.servicesinterfaces.ISuscripcionService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioSuscripcionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarioSuscripcion")
public class UsuarioSuscripcionController {
    @Autowired
    private IUsuarioSuscripcionService uSS;
    @Autowired
    private ISuscripcionService isSS;
    @Autowired
    private IMetodoPagoService isMP;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<UsuarioSuscripcion> tips = uSS.list();
        if (tips.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tips registrados de los Usuarios.");
        }
        List<UsuarioSuscripcionDTO> listDTO = tips.stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u, UsuarioSuscripcionDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        UsuarioSuscripcion u = uSS.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        uSS.delete(id);
        return ResponseEntity.ok("El usuario con ID " + id + " fue eliminado correctamente.");
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody UsuarioSuscripcionDTO dto) {
        if (dto.getFechaInicio() == null || dto.getIdSuscripcion() == null || dto.getIdUsuario() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, complete todos los campos de forma válida.");
        }
        int id = dto.getIdUsuario().getIdUsuario();
        UsuarioSuscripcion us = uSS.listId(id);
        if (us == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioSuscripcion e = m.map(dto, UsuarioSuscripcion.class);
        uSS.insert(e);
        return ResponseEntity.ok("El estado de ánimo con ID " + e.getIdSuscripcion() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        UsuarioSuscripcion e = uSS.listId(id);
        if (e == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un estado de ánimo registrado con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioSuscripcionDTO dto = m.map(e, UsuarioSuscripcionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioSuscripcionDTO dto) {
        if (dto.getFechaInicio() == null || dto.getIdSuscripcion() == null || dto.getIdUsuario() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, complete todos los campos de forma válida.");
        }
        ModelMapper m = new ModelMapper();
        UsuarioSuscripcion e = m.map(dto, UsuarioSuscripcion.class);

        UsuarioSuscripcion existente = uSS.listId(e.getIdUsuarioSuscripcion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un estado de ánimo registrado con el ID: " + e.getIdUsuarioSuscripcion());
        }

        uSS.update(e);
        return ResponseEntity.ok("El estado de ánimo con ID " + e.getIdUsuarioSuscripcion() + " fue modificado correctamente.");
    }
}
