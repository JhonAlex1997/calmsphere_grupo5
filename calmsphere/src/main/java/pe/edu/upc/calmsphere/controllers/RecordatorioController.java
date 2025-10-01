package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.RecordatorioDTO;
import pe.edu.upc.calmsphere.entities.Recordatorio;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.servicesinterfaces.IRecordatorioService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recordatorios")
public class RecordatorioController {
    @Autowired
    private IRecordatorioService service;
    @Autowired
    private IUsuarioService uservice;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<Recordatorio> recordatorios = service.list();

        if (recordatorios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron recordatorios registrados");
        }

        List<RecordatorioDTO> listaDTO = recordatorios.stream().map(r->{
            ModelMapper m = new ModelMapper();
            return m.map(r, RecordatorioDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody RecordatorioDTO dto) {
        Usuario existe = uservice.listId(dto.getIdUsuario().getIdUsuario());
        if (existe == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se puede registrar, ya que no existe un usuario con el ID: " + dto.getIdUsuario().getIdUsuario());
        }

        ModelMapper m = new ModelMapper();
        Recordatorio r = m.map(dto, Recordatorio.class);
        service.insert(r);
        return ResponseEntity.ok("El recordatorio con ID " + r.getIdRecordatorio() + " fue registrado correctamente");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Recordatorio r = service.listId(id);
        if (r == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un recordatorio con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecordatorioDTO dto = m.map(r, RecordatorioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recordatorio r = service.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un recordatorio con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El recordatorio con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody Recordatorio dto) {
        ModelMapper m = new ModelMapper();
        Recordatorio r = m.map(dto, Recordatorio.class);

        // Validación de existencia
        Recordatorio existente = service.listId(r.getIdRecordatorio());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un recordatorio con el ID: " + r.getIdRecordatorio());
        }

        Usuario existe = uservice.listId(dto.getIdUsuario().getIdUsuario());
        if (existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + dto.getIdUsuario().getIdUsuario());
        }

        // Actualización si pasa validaciones
        service.update(r);
        return ResponseEntity.ok("El recordatorio con ID " + r.getIdRecordatorio() + " fue modificado correctamente.");
    }
}
