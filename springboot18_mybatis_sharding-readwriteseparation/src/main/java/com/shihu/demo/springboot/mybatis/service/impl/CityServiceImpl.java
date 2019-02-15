package com.shihu.demo.springboot.mybatis.service.impl;

import com.shihu.demo.springboot.mybatis.dao.CityDao;
import com.shihu.demo.springboot.mybatis.model.City;
import com.shihu.demo.springboot.mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    @Override
    public int insert(City city) {
        return cityDao.insert(city);
    }

    @Override
    public int insertCollection(List<City> cityList) {
        return cityDao.insertCollection(cityList);
    }

    @Override
    public List<City> list() {
        return cityDao.list();
    }
}
