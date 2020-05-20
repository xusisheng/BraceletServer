package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.properties.ApiUri;
import com.aw.braceletserver.entity.LoginResult;
import com.aw.braceletserver.entity.UserInfo;
import com.aw.braceletserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ApiUri apiUri;

    @Cacheable(value="myCache", key="'user'+#user", unless = "#result eq null")
    @Override
    public LoginResult login(String user, String pass) throws Exception {
//        Map<String, Object> params = new HashMap();
//        params.put("name", user);
//        params.put("pass", pass);
//        HttpClientResult _result = HttpClientUtils.doPost(apiUri.getLogin(), params);
//        if (_result.getCode() == 200) {
//            JSONObject objJson = JSONObject.parseObject(_result.getContent());
//            LoginResult loginResult = JSON.toJavaObject(objJson, LoginResult.class);
//            loginResult.setAccessToken("74FBE649B34FC42CE01414B8556BFC86");
//            return loginResult;
//        }
        return null;
    }

    @Override
    public UserInfo getUserByToken(String token) {
        UserInfo userInfo = new UserInfo();
        return userInfo;
    }
}
