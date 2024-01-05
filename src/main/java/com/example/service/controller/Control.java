package com.example.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Control {
    @RequestMapping("home")
    public String index(){
        return "index";
    }
}
