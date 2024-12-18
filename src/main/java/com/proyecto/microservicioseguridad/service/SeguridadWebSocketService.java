package com.proyecto.microservicioseguridad.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SeguridadWebSocketService {
    private final SimpMessagingTemplate template;
    private final SeguridadService seguridadService;

    public SeguridadWebSocketService(SimpMessagingTemplate template, SeguridadService seguridadService) {
        this.template = template;
        this.seguridadService = seguridadService;
    }

    @Scheduled(fixedRate = 2000)
    public void sendPoliceCarsUpdates() {
        template.convertAndSend("/topic/seguirdad-coches", seguridadService.getCars());
    }
}
