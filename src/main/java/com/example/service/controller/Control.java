package com.example.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Control {
    @GetMapping("/a")
    public String hello(Model model) {
        model.addAttribute("pageTitle", "Welcome to My Page");
        model.addAttribute("pageTitle", "Welcome to My Page");
        model.addAttribute("message", "This is a Thymeleaf example.");
        return "home"; // Trả về tên của template Thymeleaf (không có đuôi .html)
    }
}
