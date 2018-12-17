package com.shihu.demo.springboot.restfull.controller;

import com.shihu.demo.springboot.restfull.model.User;
import com.shihu.demo.springboot.restfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "async/users")
public class UserAsyncController {
    @Autowired
    UserService userService;          // 用户服务层


    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping()
    public List<User> findAllUser() {
        long s=System.currentTimeMillis();
        List<User> userList=null;
        Future<List<User>> userFlux1=userService.findAllAsync();
        Future<List<User>> userFlux2=userService.findAllAsync();
        Future<List<User>> userFlux3=userService.findAllAsync();
        Future<List<User>> userFlux4=userService.findAllAsync();
        try {
            userList=userFlux1.get();
            userList=userFlux2.get();
            userList=userFlux3.get();
            userList=userFlux4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("共使用了"+(end-s)/1000+"秒");
        return userList;
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
