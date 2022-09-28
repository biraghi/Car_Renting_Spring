package com.carrenting.spring.controller;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private String getIndex(Model model, HttpSession httpSession, Principal principal)
    {
        User userLogged = userService.getUserFromUsername(principal.getName());
        httpSession.setAttribute("userLogged", userLogged);
        return "index";
    }

    @GetMapping(value = "dati")
    private String getDati(Model model)
    {
        return "dati";
    }
}
