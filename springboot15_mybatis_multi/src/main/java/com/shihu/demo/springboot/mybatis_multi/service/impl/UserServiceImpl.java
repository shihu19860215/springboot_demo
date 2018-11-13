package com.shihu.demo.springboot.mybatis_multi.service.impl;

import com.shihu.demo.springboot.mybatis_multi.dao.cluster.CityDao;
import com.shihu.demo.springboot.mybatis_multi.dao.master.UserDao;
import com.shihu.demo.springboot.mybatis_multi.model.City;
import com.shihu.demo.springboot.mybatis_multi.model.User;
import com.shihu.demo.springboot.mybatis_multi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("襄阳");
        user.setCity(city);
        return user;
    }
}
