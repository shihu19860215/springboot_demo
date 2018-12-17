package com.shihu.demo.springboot.restfull.service;


import com.shihu.demo.springboot.restfull.model.User;

import java.util.List;
import java.util.concurrent.Future;

/**
 * User 业务层接口
 *
 * Created by bysocket on 24/07/2017.
 */
public interface UserService {

    Future<List<User>> findAllAsync();

    List<User> findAll();

    Long insertByUser(User user);

    Long update(User user);

    Long delete(Long id);

    User findById(Long id);
}
