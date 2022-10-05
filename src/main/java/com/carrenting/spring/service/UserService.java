package com.carrenting.spring.service;

import com.carrenting.spring.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserFromId(int id);

    User getUserFromUsername(String username);

    void addUser(User user);

    void delUserFromId(int id);

    User setParamForUpdate(User oldU, User newU);
}
