package com.messenger.controller;

import com.messenger.database.MessageEntity;
import com.messenger.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("sendMessage")
    ResponseEntity<MessageEntity> sendMessage(@RequestBody MessageEntity message){
        MessageEntity newMessage=messageService.sendMessage(message);
        return ResponseEntity.ok(newMessage);
    }
}
