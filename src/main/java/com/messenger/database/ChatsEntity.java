package com.messenger.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "chats", schema = "public", catalog = "postgres")
public class ChatsEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "chat_name")
    private String chatName;
    @Basic
    @Column(name = "chat_members")
    private int[] memberIds;
    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime;
}
