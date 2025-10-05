
package pe.edu.upc.calmsphere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.ProfesionalServicioDTOInsert;
import pe.edu.upc.calmsphere.dtos.ProfesionalServicioDTOList;
import pe.edu.upc.calmsphere.dtos.ProfesionalServicioDTOUpdate;
import pe.edu.upc.calmsphere.entities.Disponibilidad;
import pe.edu.upc.calmsphere.entities.ProfesionalServicio;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.servicesinterfaces.IProfesionalServicioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profesional-servicios")
public class ProfesionalServicioController {

    @Autowired
    private IProfesionalServicioService service;

    private ProfesionalServicioDTOList toDTO(ProfesionalServicio ps) {
        ProfesionalServicioDTOList dto = new ProfesionalServicioDTOList();
        dto.setIdProfesionalServicio(ps.getIdProfesionalServicio());
        dto.setNombre(ps.getNombre());
        dto.setDuracionMin(ps.getDuracionMin());
        dto.setPrecioBase(ps.getPrecioBase());
        dto.setIdDisponibilidad(ps.getDisponibilidad() != null ? ps.getDisponibilidad().getDisponibilidadId() : 0);
        dto.setIdUsuario(ps.getUsuario() != null ? ps.getUsuario().getIdUsuario() : 0);
        return dto;
    }

    private ProfesionalServicio toEntity(ProfesionalServicioDTOInsert dto) {
        ProfesionalServicio ps = new ProfesionalServicio();
        ps.setNombre(dto.getNombre());
        ps.setDuracionMin(dto.getDuracionMin());
        ps.setPrecioBase(dto.getPrecioBase());
        Disponibilidad d = new Disponibilidad();
        d.setDisponibilidadId(dto.getIdDisponibilidad());
        Usuario u = new Usuario();
        u.setIdUsuario(dto.getIdUsuario());
        ps.setDisponibilidad(d);
        ps.setUsuario(u);
        return ps;
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ProfesionalServicio> lista = service.list();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron profesional-servicios");
        }
        List<ProfesionalServicioDTOList> listaDTO = lista.stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") int id) {
        ProfesionalServicio ps = service.listId(id);
        if (ps == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un profesional-servicio con ID: " + id);
        }
        return ResponseEntity.ok(toDTO(ps));
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ProfesionalServicioDTOInsert dto) {
        ProfesionalServicio ps = toEntity(dto);
        service.insert(ps);
        return ResponseEntity.status(HttpStatus.CREATED).body("Profesional-servicio creado con ID: " + ps.getIdProfesionalServicio());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody ProfesionalServicioDTOUpdate dto) {
        ProfesionalServicio ps = new ProfesionalServicio();
        ps.setIdProfesionalServicio(dto.getIdProfesionalServicio());
        ps.setNombre(dto.getNombre());
        ps.setDuracionMin(dto.getDuracionMin());
        ps.setPrecioBase(dto.getPrecioBase());

        Disponibilidad d = new Disponibilidad();
        d.setDisponibilidadId(dto.getIdDisponibilidad());
        ps.setDisponibilidad(d);

        Usuario u = new Usuario();
        u.setIdUsuario(dto.getIdUsuario());
        ps.setUsuario(u);

        ProfesionalServicio existente = service.listId(ps.getIdProfesionalServicio());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe con ID: " + ps.getIdProfesionalServicio());
        }

        service.update(ps);
        return ResponseEntity.ok("Profesional-servicio actualizado con ID: " + ps.getIdProfesionalServicio());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        ProfesionalServicio ps = service.listId(id);
        if (ps == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un profesional-servicio con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Profesional-servicio eliminado con ID: " + id);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/busquedas")
    public ResponseEntity<?> buscarPorUsuario(@RequestParam("idUsuario") int idUsuario) {
        List<ProfesionalServicio> lista = service.findByUsuario(idUsuario);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron servicios para el usuario ID: " + idUsuario);
        }
        List<ProfesionalServicioDTOList> listaDTO = lista.stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
