package com.messenger.controller;

import com.messenger.database.UsersEntity;
import com.messenger.dto.AuthResponseDto;
import com.messenger.requestsResponces.AuthResponse;
import com.messenger.requestsResponces.LoginRequest;
import com.messenger.security.CustomUserDetailsService;
import com.messenger.security.JWTGenerator;
import com.messenger.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


@RestController
public class UsersController {

    private AuthenticationManager authenticationManager;

    private CustomUserDetailsService userDetailsService;

    final UsersService usersService;

    private JWTGenerator jwtGenerator;

    @Autowired
    public UsersController(UsersService usersService, CustomUserDetailsService userDetailsService, AuthenticationManager authenticationManager, JWTGenerator jwtGenerator) {
        this.usersService = usersService;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UsersEntity user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        System.out.println("user signed fuck");
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<UsersEntity> register(@RequestBody UsersEntity user){
        UsersEntity newUser = usersService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

}
