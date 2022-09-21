package com.carrenting.spring.repository;

import com.carrenting.spring.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> selAllUser();

    User selUserFromId(int id);

    User selUserFromUsername(String username);

    void insUser(User user);

    void delUserFromId(int id);
}
