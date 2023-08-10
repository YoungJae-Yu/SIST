package com.web.board.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @GetMapping("test")
    // http://localhost:5050/test
    public String testPage() {
    	return "test";
    }
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public String send(String message) {
        return message;
    }
}
