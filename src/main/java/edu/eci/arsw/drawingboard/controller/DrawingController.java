package edu.eci.arsw.drawingboard.controller;

import edu.eci.arsw.drawingboard.model.DrawPoint;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DrawingController {

    @MessageMapping("/draw")
    @SendTo("/topic/draw")
    public DrawPoint draw(DrawPoint point) {
        return point;
    }

    @MessageMapping("/clear")
    @SendTo("/topic/clear")
    public String clear() {
        return "clear";
    }
}
