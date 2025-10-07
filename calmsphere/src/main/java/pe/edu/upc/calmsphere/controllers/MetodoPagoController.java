package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.ActividadDTO;
import pe.edu.upc.calmsphere.dtos.ActividadDTOList;
import pe.edu.upc.calmsphere.dtos.MetodoPagoDTO;
import pe.edu.upc.calmsphere.dtos.MetodoPagoDTOList;
import pe.edu.upc.calmsphere.entities.Actividad;
import pe.edu.upc.calmsphere.entities.MetodoPago;
import pe.edu.upc.calmsphere.servicesinterfaces.IMetodoPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodopago")
public class MetodoPagoController {
    @Autowired
    private IMetodoPagoService cMP;

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<MetodoPago> lista = cMP.list();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron Metodos de Pago");
        }
        List<MetodoPagoDTOList> listaDTO = lista.stream()
                .map(c -> new ModelMapper().map(c, MetodoPagoDTOList.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") int id) {
        MetodoPago c = cMP.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe metodo pago con el ID: " + id);
        }
        MetodoPagoDTO dto = new ModelMapper().map(c, MetodoPagoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody MetodoPagoDTO dto) {
        MetodoPago m = new ModelMapper().map(dto, MetodoPago.class);
        cMP.insert(m);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Colección registrada con ID: " + m.getIdMetodoPago());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody MetodoPagoDTO dto) {
        MetodoPago c = new ModelMapper().map(dto, MetodoPago.class);
        MetodoPago existente = cMP.listId(c.getIdMetodoPago());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un metodo de pago con el ID: " + c.getIdMetodoPago());
        }
        cMP.update(c);
        return ResponseEntity.ok("Colección actualizada con ID: " + c.getIdMetodoPago());
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('PROFESIONAL') || hasAuthority('PACIENTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        MetodoPago c = cMP.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un metodo de pago con el ID: " + id);
        }
        cMP.delete(id);
        return ResponseEntity.ok("Metodo de pago eliminada con ID: " + id);
    }

}
