package com.alex.online_store.repository;

import com.alex.online_store.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
}
