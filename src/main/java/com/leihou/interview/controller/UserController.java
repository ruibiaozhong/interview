package com.leihou.interview.controller;

import com.leihou.interview.entity.User;
import com.leihou.interview.service.UserService;
import com.leihou.interview.util.IdUtil;
import com.leihou.interview.util.JsonUtil;
import com.leihou.interview.vo.result.InfoResult;
import com.leihou.interview.vo.result.Result;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;


@RestController
public class UserController {

    @Resource
    private UserService userService;


    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 创建用户
     * @param user
     * @return
     */
    @PostMapping("/createUser")
    public Result createUser(User user) {
        InfoResult<User> result = new InfoResult<>();

        Date now = new Date();
        user.setCreateTime(now);
        user.setLastUpdateTime(now);
        user.setId(IdUtil.generateId());
        user.setLoginid(UUID.randomUUID().toString());

        userService.insert(user);

        result.setInfo(user);
        return result;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping("/getUser")
    public Result updateUser(User user) {
        InfoResult<User> result = new InfoResult();

        User u = userService.selectByPrimaryKey(user.getId());
        u.setMobile(user.getMobile());
        u.setEmail(user.getEmail());
        u.setAvatar(user.getAvatar());

        userService.updateByPrimaryKey(u);

        u.setLastUpdateTime(null);
        u.setLastLoginTime(null);
        u.setCreateTime(null);
        u.setPassword(null);
        u.setSecurityLevel(null);
        u.setType(null);

        return result;
    }



    @Resource
    private TopicExchange topicExchange;

    @PostMapping("/improveCreateUser")
    public Result improveCreateUser(User user) {
        InfoResult<User> result = new InfoResult<>();

        Date now = new Date();
        user.setCreateTime(now);
        user.setLastUpdateTime(now);
        user.setId(IdUtil.generateId());
        user.setLoginid(UUID.randomUUID().toString());
        System.out.println(topicExchange.getName());
        rabbitTemplate.convertAndSend(topicExchange.getName(), "add.user", JsonUtil.toJson(user));
        result.setInfo(user);
        return result ;
    }



































}















































