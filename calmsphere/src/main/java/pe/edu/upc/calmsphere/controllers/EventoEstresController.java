package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.EventoEstresDTO;
import pe.edu.upc.calmsphere.dtos.EventoEstresPorFechaDTO;
import pe.edu.upc.calmsphere.entities.EventoEstres;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.servicesinterfaces.IEventoEstresService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos")
public class EventoEstresController {
    @Autowired
    private IEventoEstresService service;

    @Autowired
    private IUsuarioService uservice;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<EventoEstres> eventos = service.list();

        if (eventos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron eventos registrados de los usuarios");
        }

        List<EventoEstresDTO> listaDTO = eventos.stream().map(e->{
            ModelMapper m = new ModelMapper();
            return m.map(e, EventoEstresDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody EventoEstresDTO dto) {
        int id = dto.getIdUsuario().getIdUsuario();
        Usuario us = uservice.listId(id);
        if (us == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EventoEstres e = m.map(dto, EventoEstres.class);
        service.insert(e);
        return ResponseEntity.ok("El evento con ID " + e.getIdEventoEstres() + " fue registrado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        EventoEstres e = service.listId(id);
        if (e == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un evento con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EventoEstresDTO dto = m.map(e, EventoEstresDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        EventoEstres e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un evento con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("El evento con ID " + id + " fue eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody EventoEstresDTO dto) {
        ModelMapper m = new ModelMapper();
        EventoEstres e = m.map(dto, EventoEstres.class);

        EventoEstres existente = service.listId(e.getIdEventoEstres());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un evento con el ID: " + e.getIdEventoEstres());
        }

        service.update(e);
        return ResponseEntity.ok("El evento con ID " + e.getIdEventoEstres() + " fue modificado correctamente.");
    }

    @GetMapping("/busquedas")
    public ResponseEntity<?> StatusSoftware() {
        List<String[]> eventos = service.buscarPorFecha();
        List<EventoEstresPorFechaDTO> listaPorFecha = new ArrayList<>();

        if (eventos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron eventos registrados.");
        }
        for(String[] columna: eventos) {
            EventoEstresPorFechaDTO dto = new EventoEstresPorFechaDTO();
            dto.setNombre((columna[0]));
            dto.setFecha(LocalDate.parse(columna[1]));
            listaPorFecha.add(dto);
        }
        return ResponseEntity.ok(listaPorFecha);
    }
}