package com.leihou.interview.controller;

import com.leihou.interview.entity.Customer;
import com.leihou.interview.mapper.CustomerMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {

    @Resource
    private CustomerMapper customerMapper;

    @RequestMapping("/helloworld")
    public String helloworld() {
        Customer customer = customerMapper.selectByPrimaryKey(10);



        System.out.println(customer.getData());

        return "helloworld";
    }


}





