package com.shihu.demo.springboot.redis;


import com.shihu.demo.springboot.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set(){
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        valueOperations.set("test:set","testValue1");
        Assert.assertEquals(valueOperations.get("test:set"),"testValue1");
    }
}