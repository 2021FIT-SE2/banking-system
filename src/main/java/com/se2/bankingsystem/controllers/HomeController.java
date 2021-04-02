package com.se2.bankingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "World") String name){
        model.addAttribute("name", name);
        return "index";
    }
}