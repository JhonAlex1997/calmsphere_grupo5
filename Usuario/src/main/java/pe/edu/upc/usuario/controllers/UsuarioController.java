package pe.edu.upc.usuario.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.usuario.dtos.UsuarioDTOInsert;
import pe.edu.upc.usuario.dtos.UsuarioDTOList;
import pe.edu.upc.usuario.entities.Usuario;
import pe.edu.upc.usuario.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping
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
    public ResponseEntity<String> insertar(@RequestBody UsuarioDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        service.insert(u);
        return ResponseEntity.ok("El usurio con ID " + u.getIdUsuario() + " fue registrado correctamente");
    }

    @GetMapping("/{id}")
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
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTOInsert dto) {
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
}
