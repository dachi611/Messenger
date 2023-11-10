package com.messenger.service;

import com.messenger.database.MessageEntity;
import com.messenger.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service

public class MessageServiceImpl implements MessageService{
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageEntity sendMessage(MessageEntity message) {

        return messageRepository.save(message);
    }
}