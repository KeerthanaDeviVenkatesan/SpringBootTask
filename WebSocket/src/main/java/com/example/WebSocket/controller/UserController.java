package com.example.WebSocket.controller;

import com.example.WebSocket.entity.User;
import com.example.WebSocket.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {
    @MessageMapping("/hello")
    @SendTo("/topic/users")
    public User users(Message message) throws InterruptedException {
        return new User("Hello!!,    " +
                HtmlUtils.htmlEscape(message.getName())+".....");
    }
}
