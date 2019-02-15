package com.shihu.demo.springboot.mybatis.model;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class City {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String cityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
