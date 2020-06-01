package com.aw.bracelet.service;

import com.aw.bracelet.entity.LoginResult;
import com.aw.bracelet.entity.UserInfo;

public interface UserService {

    /**
     * 登录
     *
     * @param user
     * @param pass
     * @return
     */
    LoginResult login(String user, String pass) throws Exception;

    UserInfo getUserByToken(String token);
}
