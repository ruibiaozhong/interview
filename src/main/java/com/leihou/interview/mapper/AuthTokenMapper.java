package com.leihou.interview.mapper;

import com.leihou.interview.entity.AuthToken;

public interface AuthTokenMapper {
    int deleteByPrimaryKey(String id);

    int insert(AuthToken record);

    int insertSelective(AuthToken record);

    AuthToken selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AuthToken record);

    int updateByPrimaryKey(AuthToken record);


    AuthToken findByUserId(String userId);


}