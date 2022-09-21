package com.carrenting.spring.controller;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String getUserList(Model model)
    {
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "userList";
    }
}
