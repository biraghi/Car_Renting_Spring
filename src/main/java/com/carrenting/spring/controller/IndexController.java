package com.carrenting.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping
    private String getIndex(Model model)
    {
        return "index";
    }

    @GetMapping(value = "dati")
    private String getDati(Model model)
    {
        return "dati";
    }
}
