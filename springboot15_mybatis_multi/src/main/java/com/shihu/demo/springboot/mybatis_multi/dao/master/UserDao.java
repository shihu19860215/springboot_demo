package com.shihu.demo.springboot.mybatis_multi.dao.master;

import com.shihu.demo.springboot.mybatis_multi.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 * 配置中有扫描到，无需注解
 */
public interface UserDao {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User findByName(@Param("userName") String userName);
}
