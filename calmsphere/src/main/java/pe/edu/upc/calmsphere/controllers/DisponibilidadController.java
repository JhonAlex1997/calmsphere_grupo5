package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.DisponibilidadDTO;
import pe.edu.upc.calmsphere.dtos.DisponibilidadDTOInsert;
import pe.edu.upc.calmsphere.dtos.DisponibilidadDTOList;
import pe.edu.upc.calmsphere.entities.Disponibilidad;
import pe.edu.upc.calmsphere.servicesinterfaces.IDisponibilidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadController {

    @Autowired
    private IDisponibilidadService dS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    public ResponseEntity<?> listar() {
        List<Disponibilidad> lista = dS.list();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron disponibilidades");
        }
        List<DisponibilidadDTOList> listaDTO = lista.stream()
                .map(x -> new ModelMapper().map(x, DisponibilidadDTOList.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") int id) {
        Disponibilidad d = dS.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disponibilidad no encontrada");
        }
        DisponibilidadDTOList dto = new ModelMapper().map(d, DisponibilidadDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    public ResponseEntity<String> insertar(@RequestBody DisponibilidadDTOInsert dto) {
        Disponibilidad d = new ModelMapper().map(dto, Disponibilidad.class);
        dS.insert(d);
        return ResponseEntity.ok("Disponibilidad insertada con ID: " + d.getDisponibilidadId());
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    public ResponseEntity<String> actualizar(@RequestBody DisponibilidadDTO dto) {
        Disponibilidad d = new ModelMapper().map(dto, Disponibilidad.class);
        Disponibilidad obj = dS.listId(d.getDisponibilidadId());
        if (obj == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disponibilidad no encontrada");
        }
        dS.update(d);
        return ResponseEntity.ok("Disponibilidad actualizada con ID: " + d.getDisponibilidadId());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Disponibilidad obj = dS.listId(id);
        if (obj == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disponibilidad no encontrada");
        }
        dS.delete(id);
        return ResponseEntity.ok("Disponibilidad eliminada con ID: " + id);
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    public ResponseEntity<?> buscar(@RequestParam("d") Integer diaSemana) {
        List<Disponibilidad> lista = dS.findByDiaSemana(diaSemana);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron disponibilidades para el día especificado");
        }
        List<DisponibilidadDTOList> listaDTO = lista.stream()
                .map(x -> new ModelMapper().map(x, DisponibilidadDTOList.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
