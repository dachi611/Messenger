package com.messenger.service;

import com.messenger.database.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {
    MessageEntity sendMessage(MessageEntity message);
    Page<MessageEntity> getMessages(Pageable pageable);
}
