package com.messenger.service;

import com.messenger.database.MessageEntity;
import com.messenger.repository.MessageRepository;
import com.messenger.security.SecUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class MessageServiceImpl implements MessageService{
    private final MessageRepository messageRepository;
//    private final SecUser secUser;

    public MessageServiceImpl(MessageRepository messageRepository/*, SecUser secUser*/) {
        this.messageRepository = messageRepository;
//        this.secUser = secUser;
    }

    @Override
    public MessageEntity sendMessage(MessageEntity message) {
//        message.setSenderId(secUser.getId());
        return messageRepository.save(message);
    }
    public Page<MessageEntity> getMessages(Pageable pageable){
        return messageRepository.findAll(pageable);
    }
}