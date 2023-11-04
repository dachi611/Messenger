package com.messenger.service;

import com.messenger.database.UsersEntity;
import com.messenger.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
     private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersEntity registerUser(UsersEntity user){
        return usersRepository.save(user);
    }

}
