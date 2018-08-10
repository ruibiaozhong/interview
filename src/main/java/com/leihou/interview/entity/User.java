package com.leihou.interview.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {

    private String id;

    private String username;

    private String loginid;

    private String password;

    private String mobile;

    private String email;

    private String avatar;

    private Date createTime;

    private Date lastUpdateTime;

    private Date lastLoginTime;

    private Long securityLevel;

    private Long type;


}