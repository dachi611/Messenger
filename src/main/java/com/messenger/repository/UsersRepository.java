package com.messenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.messenger.database.UsersEntity

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

}
