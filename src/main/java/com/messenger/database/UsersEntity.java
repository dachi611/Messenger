package com.messenger.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "users", schema = "public", catalog = "postgres")
public class UsersEntity {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = true, length = -1)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = -1)
    private String password;
}
