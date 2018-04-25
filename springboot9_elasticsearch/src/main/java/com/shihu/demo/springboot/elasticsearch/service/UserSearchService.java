package com.shihu.demo.springboot.elasticsearch.service;

import com.shihu.demo.springboot.validator.model.User;

import java.util.List;

public interface UserSearchService {
    List<User> findByNameAndBirthday(String name, String birthday);
    List<User> findByNameOrBirthday(String name,String birthday);
    List<User> findByName(String name);
    List<User> findByNameNot(String name);
    List<User> findByNameLike(String name);
}
