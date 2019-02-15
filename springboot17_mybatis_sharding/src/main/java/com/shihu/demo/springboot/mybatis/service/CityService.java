package com.shihu.demo.springboot.mybatis.service;

import com.shihu.demo.springboot.mybatis.model.City;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {;

    int insert(City city);
    int insertCollection(List<City> cityList);
}
