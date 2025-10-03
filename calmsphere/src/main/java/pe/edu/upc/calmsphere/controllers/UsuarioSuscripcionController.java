package pe.edu.upc.calmsphere.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.calmsphere.dtos.UsuarioSuscripcionDTO;
import pe.edu.upc.calmsphere.dtos.UsuarioTipDTO;
import pe.edu.upc.calmsphere.entities.UsuarioSuscripcion;
import pe.edu.upc.calmsphere.entities.UsuarioTip;
import pe.edu.upc.calmsphere.servicesinterfaces.IMetodoPagoService;
import pe.edu.upc.calmsphere.servicesinterfaces.ISuscripcionService;
import pe.edu.upc.calmsphere.servicesinterfaces.IUsuarioSuscripcionService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarioSuscripcion")
public class UsuarioSuscripcionController {
    @Autowired
    private IUsuarioSuscripcionService uSS;
    @Autowired
    private ISuscripcionService isSS;
    @Autowired
    private IMetodoPagoService isMP;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<UsuarioSuscripcion> tips = uSS.list();
        if (tips.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tips registrados de los Usuarios.");
        }
        List<UsuarioSuscripcionDTO> listDTO = tips.stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u, UsuarioSuscripcionDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }

}
