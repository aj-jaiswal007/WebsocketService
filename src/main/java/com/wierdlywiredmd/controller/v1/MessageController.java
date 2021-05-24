package com.wierdlywiredmd.controller.v1;

import com.wierdlywiredmd.model.ChatMessage;
import com.wierdlywiredmd.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public OutputMessage sendMessage(ChatMessage message){
        OutputMessage msg = new OutputMessage();
        msg.setSender(message.getSender());
        msg.setContent(message.getContent());
        msg.setTime(new SimpleDateFormat("HH:mm").format(new Date()));
        return msg;
    }
}
