package com.leihou.interview.mq.consumer;

import com.leihou.interview.entity.User;
import com.leihou.interview.mapper.UserMapper;
import com.leihou.interview.util.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConsumer {

    @Resource
    private UserMapper userMapper;

    @RabbitListener(queues = "addUser")
    public void addUser(String message) {
//        User user = JsonUtil.fromJson(message, User.class);
//        userMapper.insert(user);
        System.out.println("addUser  " + message );
    }

//    @RabbitListener(queues = "updateUser")
//    public void addUser2(String message) {
//        System.out.println("addUser2");
//    }



    @RabbitListener(queues = "#{updateUserQueue.name}")
    public void updateUser(String message)  {
        User user = JsonUtil.fromJson(message, User.class);
        userMapper.updateByPrimaryKey(user);
    }





}
