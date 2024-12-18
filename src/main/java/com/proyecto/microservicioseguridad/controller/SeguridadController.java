package com.proyecto.microservicioseguridad.controller;

import com.proyecto.microservicioseguridad.model.PoliceCar;
import com.proyecto.microservicioseguridad.service.SeguridadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeguridadController {

    private final SeguridadService seguridadService;

    public SeguridadController(SeguridadService seguridadService) {
        this.seguridadService = seguridadService;
    }

    @GetMapping("/seguridad/cars")
    public List<PoliceCar> getCars() {
        seguridadService.moveCars(); // Update car positions
        return seguridadService.getCars();
    }
}