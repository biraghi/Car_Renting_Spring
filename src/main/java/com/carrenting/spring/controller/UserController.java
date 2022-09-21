package com.carrenting.spring.controller;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/add")
    public String getUserFormAdd(Model model)
    {
        User user = new User();
        model.addAttribute("newUser", user);
        return "userForm";
    }

    @PostMapping (value = "add")
    public String addUser(@ModelAttribute("newUser") User user)
    {
        try{
            userService.addUser(user);
            return "redirect:/user/";
        }
        catch (Exception ex){
            return "redirect:/user/add";
        }


    }
}
