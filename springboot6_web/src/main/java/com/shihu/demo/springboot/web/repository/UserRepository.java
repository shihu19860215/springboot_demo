package com.shihu.demo.springboot.web.repository;

import com.shihu.demo.springboot.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层操作接口
 *
 * Created by bysocket on 21/07/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
