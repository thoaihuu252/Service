package com.example.service.Service;

import com.example.service.Model.Userdbb;

import com.example.service.controller.UserRepositoryWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSv {

    @Autowired
    private UserRepositoryWeb userRepository;

    // Method to get all products from the database
    public List<Userdbb> getAllUser() {
        return  (List<Userdbb>) userRepository.findAll();
    }
    public Userdbb createUser(Userdbb user) {
        return userRepository.save(user);
    }
    public void deleteUser(String user) {
        userRepository.deleteById(user);
    }
}