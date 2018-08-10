package com.leihou.interview.service;

import com.leihou.interview.entity.User;

public interface UserService {


    void insert(User user);

    int updateByPrimaryKey(User user);

    User selectByPrimaryKey(String userId);

    User findByUsername(String usermae);


}
