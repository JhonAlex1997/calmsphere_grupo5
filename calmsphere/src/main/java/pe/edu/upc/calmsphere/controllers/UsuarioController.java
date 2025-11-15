package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.UsuarioDTOInsert;
import pe.edu.upc.calmsphere.dtos.UsuarioDTOList;
import pe.edu.upc.calmsphere.dtos.UsuarioEventoEstresDTO;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<Usuario> usuarios = service.list();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios");
        }

        List<UsuarioDTOList> listaDTO = usuarios.stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u, UsuarioDTOList.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody UsuarioDTOInsert dto) {
        if (dto.getNombre() == null || dto.getApellido() == null || dto.getEmail() == null || dto.getContraseña() == null || dto.getFechaNacimiento() == null || dto.getFechaRegistro() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, complete todos los campos de forma válida.");
        }
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        service.insert(u);
        return ResponseEntity.ok("El usurio con ID " + u.getIdUsuario() + " fue registrado correctamente");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario u = service.listId(id);
        if (u == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTOList dto = m.map(u, UsuarioDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario u = service.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El usuario con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTOInsert dto) {
        if (dto.getNombre() == null || dto.getApellido() == null || dto.getEmail() == null || dto.getContraseña() == null || dto.getFechaNacimiento() == null || dto.getFechaRegistro() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Por favor, complete todos los campos de forma válida.");
        }
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);

        // Validación de existencia
        Usuario existente = service.listId(u.getIdUsuario());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + u.getIdUsuario());
        }

        // Actualización si pasa validaciones
        service.update(u);
        return ResponseEntity.ok("El usuario con ID " + u.getIdUsuario() + " fue modificado correctamente.");
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscar(@RequestParam String n) {
        List<Usuario> usuarios = service.buscarNombre(n);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron Usuarios con el nombre: " + n);
        }

        List<UsuarioDTOList> listaDTO = usuarios.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTOList.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/busquedasEventoEstres")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarEventoEstres() {
        List<String[]> usuarios = service.buscarEventoEstresPorUsuario();
        List<UsuarioEventoEstresDTO> listarPorEventoEstres = new ArrayList<>();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron eventos de estrés registrados.");
        }

        for(String[] columna:usuarios){
            UsuarioEventoEstresDTO dto = new UsuarioEventoEstresDTO();
            dto.setNombre_Usuario(columna[0]);
            dto.setId_EventoEstres(Integer.parseInt(columna[1]));
            dto.setDescripcion(columna[2]);
            dto.setFecha(LocalDate.parse(columna[3]));
            dto.setNivelEstres(Integer.parseInt(columna[4]));
            listarPorEventoEstres.add(dto);
        }

        return ResponseEntity.ok(listarPorEventoEstres);
    }
}