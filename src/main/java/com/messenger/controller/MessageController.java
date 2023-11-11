package com.messenger.controller;

import com.messenger.database.MessageEntity;
import com.messenger.service.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/sendMessage")
    ResponseEntity<MessageEntity> sendMessage(@RequestBody MessageEntity message){
        MessageEntity newMessage=messageService.sendMessage(message);
        return ResponseEntity.ok(newMessage);
    }
    @GetMapping("/getMessages")
    Page<MessageEntity> getMessages(@RequestParam int page, @RequestParam int size){
        return messageService.getMessages(PageRequest.of(page, size));
    }
}
