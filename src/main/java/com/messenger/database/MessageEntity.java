package com.messenger.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "message", schema = "public", catalog = "postgres")
public class MessageEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "chat ID")
    private Integer chatId;
    @Basic
    @Column(name = "body")
    private String body;
    @Basic
    @Column(name = "time")
    private Timestamp time;
}
