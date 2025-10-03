package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.RolDTO;
import pe.edu.upc.calmsphere.entities.Rol;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.servicesinterfaces.IRolService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService service;

    @Autowired
    private IUsuarioService uservice;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<Rol> roles = service.list();

        if (roles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron roles registrados.");
        }

        List<RolDTO> listaDTO = roles.stream().map(r->{
            ModelMapper m = new ModelMapper();
            return m.map(r, RolDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody RolDTO dto) {
        if (dto.getTipoRol() == null || dto.getIdUsuario() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, complete todos los campos de forma válida.");
        }
        int id = dto.getIdUsuario().getIdUsuario();
        Usuario us = uservice.listId(id);
        if (us == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        service.insert(r);
        return ResponseEntity.ok("El rol con ID " + r.getIdRol() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarid(@PathVariable("id") Integer id) {
        Rol r = service.listId(id);
        if (r == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(r, RolDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Rol r = service.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El rol con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        if (dto.getTipoRol() == null || dto.getIdUsuario() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, complete todos los campos de forma válida.");
        }
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);

        Rol existente = service.listId(r.getIdRol());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un rol con el ID: " + r.getIdRol());
        }

        service.update(r);
        return ResponseEntity.ok("El rol con ID " + r.getIdRol() + " fue modificado correctamente.");
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscar(@RequestParam String n) {
        List<Rol> roles = service.buscarTipoRol(n);

        if (roles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontro el tipo de rol: " + n);
        }

        List<RolDTO> listaDTO = roles.stream().map(r ->{
            ModelMapper m = new ModelMapper();
            return m.map(r, RolDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}