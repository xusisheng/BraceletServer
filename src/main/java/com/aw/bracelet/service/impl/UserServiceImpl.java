package com.aw.bracelet.service.impl;

import com.aw.bracelet.entity.LoginUserInfo;
import com.aw.bracelet.properties.ApiUri;
import com.aw.bracelet.entity.LoginResult;
import com.aw.bracelet.entity.UserInfo;
import com.aw.bracelet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ApiUri apiUri;

    @Cacheable(value="myCache", key="'user'+#user", unless = "#result eq null")
    @Override
    public LoginResult login(String user, String pass) throws Exception {
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setUserId(33845);

        LoginResult loginResult = new LoginResult();
        loginResult.setAccessToken("74FBE649B34FC42CE01414B8556BFC86");
        loginResult.setItem(loginUserInfo);
        return loginResult;
    }

    @Override
    public UserInfo getUserByToken(String token) {
        UserInfo userInfo = new UserInfo();
        return userInfo;
    }
}
