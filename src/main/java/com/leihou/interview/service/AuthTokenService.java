package com.leihou.interview.service;

import com.leihou.interview.entity.AuthToken;

public interface AuthTokenService {


    AuthToken findByUserId(String userId);
}
