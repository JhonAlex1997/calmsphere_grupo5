package pe.edu.upc.usuario.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.usuario.dtos.UsuarioDTOInsert;
import pe.edu.upc.usuario.dtos.LugarDTO;
import pe.edu.upc.usuario.entities.Usuario;
import pe.edu.upc.usuario.entities.Lugar;
import pe.edu.upc.usuario.servicesinterfaces.ILugarService;
import pe.edu.upc.usuario.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lugares")
public class LugarController {
    @Autowired
    private ILugarService service;

    @Autowired
    private IUsuarioService uservice;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Lugar> lugares = service.list();

        if (lugares.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron lugares registrados de los usuarios");
        }

        List<LugarDTO> listaDTO = lugares.stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u, LugarDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody LugarDTO dto) {
        int id = dto.getIdUsuario().getIdUsuario();
        Usuario us = uservice.listId(id);
        if (us == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        Lugar l = m.map(dto, Lugar.class);
        service.insert(l);
        return ResponseEntity.ok("El lugar con ID " + l.getIdLugar() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Lugar l = service.listId(id);
        if (l == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un lugar con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        LugarDTO dto = m.map(l, LugarDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Lugar l = service.listId(id);
        if (l == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un lugar con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El lugar con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody LugarDTO dto) {
        ModelMapper m = new ModelMapper();
        Lugar l = m.map(dto, Lugar.class);

        // Validación de existencia
        Lugar existente = service.listId(l.getIdLugar());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un lugar con el ID: " + l.getIdLugar());
        }

        // Actualización si pasa validaciones
        service.update(l);
        return ResponseEntity.ok("El lugar con ID " + l.getIdLugar() + " fue modificado correctamente.");
    }

    @GetMapping("/busquedas")
    public ResponseEntity<?> buscar(@RequestParam String n) {
        List<Lugar> lugares = service.buscarNombre(n);

        if (lugares.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron lugares con el nombre: " + n);
        }

        List<LugarDTO> listaDTO = lugares.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, LugarDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}
