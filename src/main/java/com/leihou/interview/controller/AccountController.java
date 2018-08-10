package com.leihou.interview.controller;

import com.leihou.interview.entity.AuthToken;
import com.leihou.interview.entity.User;
import com.leihou.interview.service.AuthTokenService;
import com.leihou.interview.service.UserService;
import com.leihou.interview.util.CryptologyUtil;
import com.leihou.interview.vo.result.InfoResult;
import com.leihou.interview.vo.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户账号
 */
@RestController
@RequestMapping("account-controller")
public class AccountController {

    @Resource
    private UserService userService;

    @Resource
    private AuthTokenService authTokenService;

    /**
     * 登陆接口
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/Login")
    public Result login(@NotNull String username, @NotNull String password) {
        InfoResult result = new InfoResult();
        User user = userService.findByUsername(username.trim());
        if (!user.getPassword().equals(CryptologyUtil.md5UpperCase(password.trim()))) {
            result.setInvild("用户名与密码不匹配");
            return result;
        }

        Date now = new Date();

        user.setLastLoginTime(now);
        user.setLastUpdateTime(now);

        userService.updateByPrimaryKey(user);

        AuthToken authToken = authTokenService.findByUserId(user.getId());
        result.setInfo(authToken.getToken());
        return result;



    }

}



































