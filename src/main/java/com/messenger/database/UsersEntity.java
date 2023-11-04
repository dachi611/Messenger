package com.messenger.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users", schema = "public", catalog = "postgres")
public class UsersEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;
}
