package com.shihu.demo.springboot.restfull.controller;

import com.shihu.demo.springboot.restfull.model.User;
import com.shihu.demo.springboot.restfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;          // 用户服务层


    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping()
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @PostMapping()
    public Long saveUser(@RequestBody User user) {
        return userService.insertByUser(user);
    }

    @PutMapping()
    public Long updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(value = "/{id}")
    public Long deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
