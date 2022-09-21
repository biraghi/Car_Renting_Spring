package com.carrenting.spring.service;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.selAllUser();
    }

    @Override
    public User getUserFromId(int id) {
        return null;
    }

    @Override
    public User getUserFromUsername(String username) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void delUserFromId(int id) {

    }
}
