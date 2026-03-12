# ARSW LAB05 - Interactive Drawing Board (Backend)

Servidor backend para un tablero de dibujo colaborativo en tiempo real. Permite que multiples usuarios dibujen simultaneamente en un tablero compartido mediante WebSockets con STOMP. Cada trazo dibujado por un usuario se transmite a todos los demas conectados, y cualquier usuario puede borrar el tablero para todos.

## Getting Started

Estas instrucciones te permitiran obtener una copia del proyecto corriendo en tu maquina local para desarrollo y pruebas. Revisa la seccion de deployment para notas sobre como desplegar en un sistema en produccion.

### Prerequisites

- Java 17 o superior
- Apache Maven 3.8+

```
java -version
mvn -version
```

### Installing

Clonar el repositorio

```
git clone https://github.com/tu-usuario/ARSW-LAB05-BACKEND.git
cd ARSW-LAB05-BACKEND
```

Compilar el proyecto

```
mvn clean compile
```

Ejecutar el servidor (puerto 8080 por defecto)

```
mvn spring-boot:run
```

El servidor estara disponible en `http://localhost:8080`. El endpoint WebSocket STOMP se expone en `http://localhost:8080/ws`.

## Architecture

```
src/main/java/edu/eci/arsw/drawingboard/
├── DrawingBoardApplication.java       # Clase principal Spring Boot
├── config/
│   ├── WebSocketConfig.java           # Configuracion STOMP + SockJS
│   └── CorsConfig.java               # Configuracion CORS global
├── controller/
│   └── DrawingController.java         # Controller STOMP (draw y clear)
└── model/
    └── DrawPoint.java                 # Entidad: x, y, color
```

## WebSocket Endpoints

| Tipo        | Destino        | Descripcion                              |
|-------------|----------------|------------------------------------------|
| STOMP Send  | `/app/draw`    | Envia un punto dibujado (x, y, color)    |
| STOMP Send  | `/app/clear`   | Envia la orden de borrar el tablero      |
| Subscribe   | `/topic/draw`  | Recibe puntos dibujados por otros        |
| Subscribe   | `/topic/clear` | Recibe la orden de borrado               |

### DrawPoint (JSON)

```json
{
  "x": 350.0,
  "y": 240.0,
  "color": "#FF5733"
}
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework backend
* [Spring WebSocket](https://docs.spring.io/spring-framework/reference/web/websocket.html) - Soporte WebSocket con STOMP
* [Maven](https://maven.apache.org/) - Gestion de dependencias
* [SockJS](https://github.com/sockjs) - Fallback para WebSocket

## Authors

* **Juan Sebastian Puentes Julio** - *ARSW Lab 05*

## Acknowledgments

* Escuela Colombiana de Ingenieria Julio Garavito - ARSW
* Proyecto de referencia p5.js: https://github.com/dnielben/ipp5
