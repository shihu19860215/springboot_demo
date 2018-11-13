package com.shihu.demo.springboot.mybatis_multi.dao.cluster;

import com.shihu.demo.springboot.mybatis_multi.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 * f配置中有扫描到，无需注解
 */
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
