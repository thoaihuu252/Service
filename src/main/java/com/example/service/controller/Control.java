package com.example.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Control {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
