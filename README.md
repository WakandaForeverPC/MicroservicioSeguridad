# Explicación de las Clases

## `MicroservicioSeguridadApplication`
- **Descripción**: Clase principal que inicia la aplicación Spring Boot.

## `SeguridadController`
- **Descripción**: Controlador REST que expone el endpoint `/seguridad/cars` para obtener la lista de coches de policía y actualizar sus posiciones.

## `SeguridadService`
- **Descripción**: 
  - Maneja la lógica de movimiento de los coches de policía en una cuadrícula.
  - Actualiza las posiciones de los coches de policía.
  - Gestiona la creación de nuevos coches cuando uno sale del mapa.

## `SeguridadUpdater`
- **Descripción**: 
  - Componente programado que actualiza periódicamente las posiciones de los coches de policía cada 2 segundos.
  - Envía actualizaciones a los clientes a través de WebSockets.

## `SeguridadWebSocketService`
- **Descripción**: Servicio que maneja la comunicación WebSocket para enviar actualizaciones en tiempo real de los coches de policía a los clientes conectados.

## `WebSocketConfig`
- **Descripción**: 
  - Configura la mensajería WebSocket para la comunicación en tiempo real.
  - Define el endpoint `/transport-websocket` para las conexiones WebSocket.

## `PoliceCar`
- **Descripción**: Modelo que representa un coche de policía con los siguientes atributos:
  - **`id`**: Identificador único del coche.
  - **`x` y `y`**: Coordenadas en la cuadrícula.
  - **`direction`**: Dirección del movimiento del coche.

---

## Utilidad del Proyecto
Este proyecto es un microservicio de seguridad que simula el movimiento de coches de policía en una cuadrícula. Utiliza **Spring Boot** para la creación del servicio, **WebSockets** para la comunicación en tiempo real y **Eureka** para la gestión de servicios.

- Los coches de policía se mueven automáticamente dentro de la cuadrícula.
- Sus posiciones se actualizan periódicamente y se envían a los clientes conectados mediante WebSockets.

### Aplicaciones
Este proyecto puede ser útil para sistemas que requieran monitoreo en tiempo real de vehículos de seguridad, como:
- Sistemas de gestión de tráfico.
- Simulaciones de seguridad.
