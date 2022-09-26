package com.carrenting.spring.service;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.selAllUser();
    }

    @Override
    public User getUserFromId(int id) {
        return userRepository.selUserFromId(id);
    }

    @Override
    public User getUserFromUsername(String username) {
        return userRepository.selUserFromUsername(username);
    }

    @Override
    public void addUser(User user) {
        userRepository.insUser(user);
    }

    @Override
    public void delUserFromId(int id) {
        userRepository.delUserFromId(id);
    }
}
