package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.ActividadDTO;
import pe.edu.upc.calmsphere.dtos.ActividadDTOInsert;
import pe.edu.upc.calmsphere.dtos.ActividadDTOList;
import pe.edu.upc.calmsphere.entities.Actividad;
import pe.edu.upc.calmsphere.servicesinterfaces.IActividadService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    private IActividadService iAS;
    @Autowired
    private IUsuarioService uservice;

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Actividad> lista = iAS.list();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron Actividades");
        }
        List<ActividadDTOList> listaDTO = lista.stream()
                .map(c -> new ModelMapper().map(c, ActividadDTOList.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PutMapping
    public ResponseEntity<String> insertar(@RequestBody ActividadDTOInsert dto) {
        Actividad a = new ModelMapper().map(dto, Actividad.class);
        iAS.insert(a);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Colección registrada con ID: " + a.getIdActividad());
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Actividad e = iAS.listId(id);
        if (e == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un estado de ánimo registrado con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ActividadDTOList dto = m.map(e, ActividadDTOList.class);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Actividad c = iAS.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una actividad con el ID: " + id);
        }
        iAS.delete(id);
        return ResponseEntity.ok("Actividad eliminada con ID: " + id);
    }

    @GetMapping("/busquedas")
    public List<ActividadDTO> buscarfechainicio(LocalDate fechaInicio){
        return iAS.findByFechaRegistro(fechaInicio).stream().map( y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, ActividadDTO.class);
        }).collect(Collectors.toList());
    }
}