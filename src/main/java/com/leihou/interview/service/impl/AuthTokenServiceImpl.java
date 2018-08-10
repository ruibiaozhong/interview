package com.leihou.interview.service.impl;

import com.leihou.interview.entity.AuthToken;
import com.leihou.interview.mapper.AuthTokenMapper;
import com.leihou.interview.service.AuthTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthTokenServiceImpl implements AuthTokenService {


    @Resource
    private AuthTokenMapper authTokenMapper;

    @Override
    public AuthToken findByUserId(String userId) {
        return authTokenMapper.findByUserId(userId);
    }



}
