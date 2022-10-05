package com.carrenting.spring.controller;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @GetMapping
    private String getUserList(Model model)
    {
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @GetMapping(value = "/update/{id}")
    private String getUserFormUpdate(@PathVariable("id")int id, Model model)
    {
        User user = userService.getUserFromId(id);
        model.addAttribute("newUser", user);
        model.addAttribute("type", "update");
        return "userForm";
    }



    @GetMapping(value = "/add")
    private String getUserFormAdd(Model model)
    {
        User user = new User();
        model.addAttribute("newUser", user);
        model.addAttribute("type", "add");
        return "userForm";
    }

    @PostMapping (value = "/add")
    private String addUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("type", "add");
            return "userForm";
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/user";


    }

    @PostMapping (value = "update/{id}")
    private String updateUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("type", "update");
            return "userForm";
        }

        User oldUser = userService.getUserFromId(newUser.getId());
        oldUser.setFirstname(newUser.getFirstname());
        oldUser.setLastname(newUser.getLastname());
        oldUser.setBirthDate(newUser.getBirthDate());
        oldUser.setUsername(newUser.getUsername());
        userService.addUser(oldUser);

        return "redirect:/user";


    }

    @GetMapping(value = "/delete/{id}")
    private String deleteUserById(@PathVariable("id")int id, Model model){
        userService.delUserFromId(id);
        return "redirect:/user";
    }
}
