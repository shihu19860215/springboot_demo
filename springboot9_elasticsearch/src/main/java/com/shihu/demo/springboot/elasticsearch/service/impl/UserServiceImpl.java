package com.shihu.demo.springboot.elasticsearch.service.impl;

import com.shihu.demo.springboot.elasticsearch.model.User;
import com.shihu.demo.springboot.elasticsearch.repository.UserRepository;
import com.shihu.demo.springboot.elasticsearch.service.UserService;
import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * User 业务层实现
 *
 * Created by bysocket on 24/07/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    /* 分页参数 */
    Integer DEFAULT_PAGE_SIZE = 50;          // 每页数量
    Integer DEFAULT_PAGE_NUMBER = 0; // 默认当前页码


    @Autowired
    UserRepository userRepository;

    /**
     * 查找数量过大会导致异常，默认分下页
     * @return
     */
    @Override
    public List<User> findAll() {
        return findAll(null,null);
    }

    @Override
    public List<User> findAll(Integer pageNumber, Integer pageSize) {
        if(null==pageNumber||pageNumber<0){
            pageNumber=DEFAULT_PAGE_NUMBER;
        }
        if(null==pageSize||pageSize<1){
            pageSize=DEFAULT_PAGE_SIZE;
        }
        Pageable pageable=new PageRequest(pageNumber,pageSize);
        Iterable<User> userIt=userRepository.findAll(pageable);
        List<User> list=null;
        if(null!=userIt) {
            list=IteratorUtils.toList(userIt.iterator());
        }randmonSave();
        return list;
    }

    @Override
    public User insertByUser(User user) {
        user.setId(System.currentTimeMillis());
        LOGGER.info("新增用户：" + user.toString());
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        LOGGER.info("更新用户：" + user.toString());
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);

        LOGGER.info("删除用户：" + user.toString());
        return user;
    }

    @Override
    public User findById(Long id) {
        LOGGER.info("获取用户 ID ：" + id);
        return userRepository.findById(id).get();
    }

    public void randmonSave(){
        Random random=new Random();
        for(int i=0;i<10000;i++){
            User user=new User();
            user.setId(System.currentTimeMillis());
            if(i%3==0){
                user.setName("程"+random.nextInt(10000));
            }else if(i%3==1){
                user.setName("王"+random.nextInt(10000));
            }else {
                user.setName("李"+random.nextInt(10000));
            }
            String date="";
            int age=random.nextInt(60)+1;
            date+=(2018-age)+"-";
            date+="0"+(random.nextInt(8)+1)+"-";
            date+=10+random.nextInt(17);
            user.setBirthday(date);
            //user.setAge(age);

            int rnum=random.nextInt(4)+1;
            Date[] arr=new Date[rnum];
            for(int j=0;j<rnum;j++){
                long now=System.currentTimeMillis();
                long rd=now-random.nextLong()%315360000000L;
                arr[j]=new Date(rd);
            }
            user.setWorkDate(arr);
            userRepository.save(user);
        }
    }

}
