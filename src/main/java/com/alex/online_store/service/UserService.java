package com.alex.online_store.service;

import com.alex.online_store.entity.UserEntity;

public interface UserService {

    UserEntity findOrCreateUser(String name, String surname,
                                String phone, String email,
                                String address);
}
