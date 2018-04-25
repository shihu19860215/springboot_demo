package com.shihu.demo.springboot.restfull.repository;

import com.shihu.demo.springboot.restfull.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久层操作接口
 *
 * Created by bysocket on 21/07/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
