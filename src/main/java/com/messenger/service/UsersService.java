package com.messenger.service;

import com.messenger.database.UsersEntity;

public interface UsersService {
    UsersEntity registerUser(UsersEntity user);
}
