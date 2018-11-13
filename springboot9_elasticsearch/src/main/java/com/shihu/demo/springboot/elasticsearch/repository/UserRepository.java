package com.shihu.demo.springboot.elasticsearch.repository;

import com.shihu.demo.springboot.elasticsearch.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 用户持久层操作接口
 *
 * Created by bysocket on 21/07/2017.
 */
public interface UserRepository extends ElasticsearchRepository<User, Long> {
    List<User> findByNameAndBirthday(String name, String birthday);
    List<User> findByNameOrBirthday(String name,String birthday);
    List<User> findByName(String name);
    List<User> findByNameNot(String name);
    List<User> findByNameLike(String name);
}
