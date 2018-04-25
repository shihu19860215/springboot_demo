package com.shihu.demo.springboot.restfull.controller;

import com.shihu.demo.springboot.restfull.handler.UserHandler;
import com.shihu.demo.springboot.restfull.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户控制层
 *
 */
@RestController
@RequestMapping(value = "/flux/users")
public class UserFluxController {
    @Autowired
    UserHandler userHandler;          // 用户服务层


    @GetMapping(value = "/{id}")
    public Mono<User> findUserById(@PathVariable("id") Long id) {
        return userHandler.findById(id);
    }

    @GetMapping()
    public Flux<User> findAllUser() {
        return userHandler.findAll();
    }

    @PostMapping()
    public Mono<Long> saveUser(@RequestBody User user) {
        return userHandler.insertByUser(user);
    }

    @PutMapping()
    public Mono<Long> updateUser(@RequestBody User user) {
        return userHandler.update(user);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteUser(@PathVariable("id") Long id) {
        return userHandler.delete(id);
    }
}