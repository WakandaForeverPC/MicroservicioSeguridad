package com.proyecto.microservicioseguridad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seguridad")
public class SeguridadController {

    @GetMapping
    public String obtenerSeguridad() {
        // Lógica para obtener información de seguridad
        return "Información de seguridad";
    }

    @PostMapping
    public String crearSeguridad(@RequestBody String nuevaSeguridad) {
        // Lógica para crear nueva información de seguridad
        return "Nueva seguridad creada";
    }
}