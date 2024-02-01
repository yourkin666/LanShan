package com.example.lanshan.service;

import com.example.lanshan.pojo.Person;
import com.example.lanshan.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);

    Person findPerson(String username);

    void updateAvatar(String avatarUrl);
}
