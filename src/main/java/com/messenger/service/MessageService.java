package com.messenger.service;

import com.messenger.database.MessageEntity;

public interface MessageService {
    MessageEntity sendMessage(MessageEntity message);
}
