package pe.edu.upc.calmsphere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.calmsphere.servicesinterfaces.IActividadService;


@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    private IActividadService iAS;




}
