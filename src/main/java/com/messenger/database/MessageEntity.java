package com.messenger.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "messages", schema = "public", catalog = "postgres")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messages_id_seq")
    @SequenceGenerator(name = "messages_id_seq", sequenceName = "messages_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "chat_id")
    private Integer chatId;
    @Basic
    @Column(name = "message_body")
    private String body;
    @Basic
    @Column(name = "time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime time;
    @Basic
    @Column(name="sender_id")
    private int senderId;
}
