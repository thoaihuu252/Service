package com.example.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class Control {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
