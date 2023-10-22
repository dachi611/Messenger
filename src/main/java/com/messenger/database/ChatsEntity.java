package com.messenger.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "chats", schema = "public", catalog = "postgres")
public class ChatsEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "chat name")
    private String chatName;
    @Basic
    @Column(name = "member ID")
    private Object memberId;
}
