package com.shihu.demo.springboot.mybatis.dao;

import com.shihu.demo.springboot.mybatis.model.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityDao {

    int insert(City city);
    int insertCollection(List<City> cityList);
}
