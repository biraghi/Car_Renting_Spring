package com.carrenting.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping
    public String getIndex(Model model)
    {
        return "index";
    }

    @GetMapping(value = "dati")
    public String getDati(Model model)
    {
        return "dati";
    }
}
