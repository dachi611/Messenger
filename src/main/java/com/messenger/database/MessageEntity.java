package com.messenger.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "messages", schema = "public", catalog = "postgres")
public class MessageEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "chat_id")
    private Integer chatId;
    @Basic
    @Column(name = "message_body")
    private String body;
    @Basic
    @Column(name = "time")
    private Timestamp time;
    @Basic
    @Column(name="sender_id")
    private int senderId;
}
