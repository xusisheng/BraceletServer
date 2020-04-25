package com.aw.braceletserver.service;

import com.aw.braceletserver.entity.LoginResult;
import com.aw.braceletserver.entity.UserInfo;

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
