package com.shihu.demo.springboot.elasticsearch.service.impl;

import com.shihu.demo.springboot.elasticsearch.model.User;
import com.shihu.demo.springboot.elasticsearch.repository.UserRepository;
import com.shihu.demo.springboot.elasticsearch.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 方法会默认分页，每页10行
 */
@Service
public class UserSearchServiceImpl implements UserSearchService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findByNameAndBirthday(String name, String birthday) {
        return userRepository.findByNameAndBirthday(name,birthday);
    }

    @Override
    public List<User> findByNameOrBirthday(String name, String birthday) {
        return userRepository.findByNameOrBirthday(name,birthday);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByNameNot(String name) {
        return userRepository.findByNameNot(name);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userRepository.findByNameLike(name);
    }
}
