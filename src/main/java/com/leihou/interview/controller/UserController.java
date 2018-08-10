package com.leihou.interview.controller;

import com.leihou.interview.entity.User;
import com.leihou.interview.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/createUser")
    public String createUser(User user) {
        userService.insert(user);
        return "success";
    }


}





