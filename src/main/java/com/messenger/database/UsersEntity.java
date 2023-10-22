package com.messenger.database;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
public class UsersEntity {
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "user name")
    private String userName;
    @Basic
    @Column(name = "first name")
    private String firstName;
    @Basic
    @Column(name = "last name")
    private String lastName;
}
