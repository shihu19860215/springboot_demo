package com.shihu.demo.springboot.restfull.service.impl;

import com.shihu.demo.springboot.restfull.model.User;
import com.shihu.demo.springboot.restfull.repository.UserRepository;
import com.shihu.demo.springboot.restfull.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * User 业务层实现
 *
 * Created by bysocket on 24/07/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    @Async
    public Future<List<User>> findAllAsync() {
        try {
            int i=new Random().nextInt(10)+1;
            TimeUnit.SECONDS.sleep(i);
            System.out.println("睡眠了"+i+"秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UserHandler");
        List<User> users=userRepository.findAll();
        return new AsyncResult<List<User>>(users);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Long insertByUser(User user) {
        LOGGER.info("新增用户：" + user.toString());
        return userRepository.save(user).getId();
    }

    @Override
    public Long update(User user) {
        LOGGER.info("更新用户：" + user.toString());
        return userRepository.saveAndFlush(user).getId();
    }

    @Override
    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
