package com.example.service.controller;

import com.example.service.Model.User;
import com.example.service.Model.Userdbb;
import com.example.service.Service.UserSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserSv userSv;
    private List<User> userList ;

    public UserController() {
        this.userList = new ArrayList<>();
        userList.add(new User("1", "John", "password1", "john@example.com", "http://example.com/john",0));
        userList.add(new User("2", "thoai", "123", "jane@example.com", "http://example.com/jane",0));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userList.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userList.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        Optional<User> existingUser = userList.stream().filter(u -> u.getId().equals(id)).findFirst();

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setPassword(updatedUser.getPassword());
            user.setEmail(updatedUser.getEmail());
            user.setUrlAvt(updatedUser.getUrlAvt());

            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        Optional<User> user = userList.stream().filter(u -> u.getId().equals(id)).findFirst();

        if (user.isPresent()) {
            userList.remove(user.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

