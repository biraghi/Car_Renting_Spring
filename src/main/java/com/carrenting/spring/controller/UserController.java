package com.carrenting.spring.controller;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    /*
    @Autowired
    UserService userService;*/

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }



    @GetMapping(value = "/")
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
        return "userForm";
    }

    @PostMapping (value = "update/{id}")
    private String updateUser(@ModelAttribute("newUser") User newUser) throws Exception {
        try{
            User oldUser = userService.getUserFromId(newUser.getId());
            oldUser.setFirstname(newUser.getFirstname());
            oldUser.setLastname(newUser.getLastname());
            oldUser.setBirthDate(newUser.getBirthDate());
            oldUser.setUsername(newUser.getUsername());
            oldUser.setPassword(newUser.getPassword());
            userService.addUser(oldUser);

            return "redirect:/user/";
        }
        catch (Exception ex){
            throw new Exception("Error");
        }
    }

    @GetMapping(value = "/add")
    private String getUserFormAdd(Model model)
    {
        User user = new User();
        model.addAttribute("newUser", user);
        return "userForm";
    }

    @PostMapping (value = "add")
    private String addUser(@ModelAttribute("newUser") User user) throws Exception {
        try{
            userService.addUser(user);
            return "redirect:/user/";
        }
        catch (Exception ex){
            throw new Exception("Error");
        }
    }

    @GetMapping(value = "/delete/{id}")
    private String deleteUserById(@PathVariable("id")int id, Model model){
        userService.delUserFromId(id);
        return "redirect:/user/";
    }
}
