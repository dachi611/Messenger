package com.messenger.controller;

import com.messenger.database.UsersEntity;
import com.messenger.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<UsersEntity> register(@RequestBody UsersEntity user){
        UsersEntity newUser = usersService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

}
