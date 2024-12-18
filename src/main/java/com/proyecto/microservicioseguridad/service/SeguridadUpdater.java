package com.proyecto.microservicioseguridad.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SeguridadUpdater {
    private final SeguridadService seguridadService;
    private final SeguridadWebSocketService seguridadWebSocketService;

    public SeguridadUpdater(SeguridadService seguridadService, SeguridadWebSocketService seguridadWebSocketService) {
        this.seguridadService = seguridadService;
        this.seguridadWebSocketService = seguridadWebSocketService;
    }

    @Scheduled(fixedRate = 2000)
    public void updateTransport() {
        seguridadService.moveCars();
        seguridadWebSocketService.sendPoliceCarsUpdates();
    }
}
