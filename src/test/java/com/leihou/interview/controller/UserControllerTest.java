package com.leihou.interview.controller;



import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.retry.backoff.Sleeper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UserControllerTest {


    @Resource
    private UserController userController;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        System.out.println("helloworld");
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @BeforeClass
    public static void s() {
        System.out.println("beforeclass");
    }


    @JunitPerfConfig(duration = 1, reporter = {ConsoleReporter.class, HtmlReporter.class}, threads = 1)
//    @Test
    public void testCreateUser() throws Exception {



        System.out.println("welcome");

//        mockMvc.perform(MockMvcRequestBuilders.get("/createUser").accept(MediaType.APPLICATION_JSON)
//                .param("username",  "username")
//                .param("loginid", "helloworld")
//                .param("password", "password")
//                .param("mobile", "mobile")
//                .param("email", "email")
//                .param("avatar", "helloworld")
//                .param("createTime", "2018-08-09 12:00:00")
//                .param("lastUpdateTime", "2018-08-09 12:00:00")
//                .param("lastLoginTime", "2018-08-09 12:00:00")
//                .param("securityLevel", "123456")
//                .param("type", "1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn().getResponse().getContentAsString();

    }









}
