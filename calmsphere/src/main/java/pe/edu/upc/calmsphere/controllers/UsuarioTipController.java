package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.UsuarioTipDTO;
import pe.edu.upc.calmsphere.entities.Tip;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.entities.UsuarioTip;
import pe.edu.upc.calmsphere.servicesinterfaces.ITipService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioTipService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuariotips")
public class UsuarioTipController {
    @Autowired
    private IUsuarioTipService service;

    @Autowired
    private IUsuarioService uservice;

    @Autowired
    private ITipService tservice;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<UsuarioTip> tips = service.list();


        if (tips.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tips registrados de los Usuarios.");
        }

        List<UsuarioTipDTO> listaDTO = tips.stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u, UsuarioTipDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody UsuarioTipDTO dto) {
        int idUs = dto.getIdUsuario().getIdUsuario();
        Usuario us = uservice.listId(idUs);
        if (us == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + idUs);
        }
        int idTp = dto.getIdTip().getIdTip();
        Tip tp = tservice.listId(idTp);
        if (tp == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un tip con el ID: " + idTp);
        }
        ModelMapper m = new ModelMapper();
        UsuarioTip u = m.map(dto, UsuarioTip.class);
        service.insert(u);
        return ResponseEntity.ok("El tip de usuario con ID " + u.getIdUsuarioTip() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarid(@PathVariable("id") Integer id) {
        UsuarioTip u = service.listId(id);
        if (u == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un tip de usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioTipDTO dto = m.map(u, UsuarioTipDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        UsuarioTip u = service.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un tip de usuario con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El tip de usuario con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioTipDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioTip u = m.map(dto, UsuarioTip.class);

        UsuarioTip existente = service.listId(u.getIdUsuarioTip());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un tip de usuario con el ID: " + u.getIdUsuarioTip());
        }

        service.update(u);
        return ResponseEntity.ok("El tip de usuario con ID " + u.getIdUsuarioTip() + " fue modificado correctamente.");
    }
}
