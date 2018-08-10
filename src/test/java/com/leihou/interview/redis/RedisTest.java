package com.leihou.interview.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {



    @Autowired
    protected RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedis() {

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
//        valueOperations.setIfAbsent("hello", "world");

        System.out.println(valueOperations.get("hello"));
    }


}
