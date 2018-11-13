package com.shihu.demo.springboot.elasticsearch.service;

import com.shihu.demo.springboot.elasticsearch.model.User;

import java.util.List;

public interface UserPageService {
    /**
     * 搜索词搜索，分页返回用户信息
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    List<User> searchCity(Integer pageNumber, Integer pageSize, String searchContent);
}
