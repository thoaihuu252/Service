package com.example.service.controller;

import com.example.service.Model.Userdbb;
import com.example.service.Service.UserSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerWeb {

    @Autowired
    private UserSv userSv;

    // Method to handle GET request at /products and return a list of all products
    @GetMapping("/user")
    public List<Userdbb> getAllProducts() {
        return userSv.getAllUser();
    }
    @PostMapping("/user/create")
    public ResponseEntity<Userdbb> CreateUser(Userdbb user) {
        try {
            Userdbb createdUser = userSv.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}