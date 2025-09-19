package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.TipDTO;
import pe.edu.upc.calmsphere.entities.Tip;
import pe.edu.upc.calmsphere.servicesinterfaces.ITipService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tips")
public class TipController {
    @Autowired
    private ITipService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Tip> tips = service.list();

        if (tips.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tips registrados.");
        }

        List<TipDTO> listaDTO = tips.stream().map(t->{
            ModelMapper m = new ModelMapper();
            return m.map(t, TipDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody TipDTO dto) {
        ModelMapper m = new ModelMapper();
        Tip t = m.map(dto, Tip.class);
        service.insert(t);
        return ResponseEntity.ok("El tip con ID " + t.getIdTip() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Tip t = service.listId(id);
        if (t == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un tip con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TipDTO dto = m.map(t, TipDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Tip t = service.listId(id);
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un tip registrado con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El tip con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TipDTO dto) {
        ModelMapper m = new ModelMapper();
        Tip t = m.map(dto, Tip.class);

        Tip existente = service.listId(t.getIdTip());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un tip con el ID: " + t.getIdTip());
        }

        service.update(t);
        return ResponseEntity.ok("El tip con ID " + t.getIdTip() + " fue modificado correctamente.");
    }
}