package com.aw.braceletserver.service;

import com.aw.braceletserver.model.TxUser;
import com.aw.braceletserver.model.TxUserExample;

import java.util.List;

public interface TxUserService {

    TxUser getUserByUserId(int userId);

    Integer selectMaxUserId();

    long countByExample(TxUserExample example);

    int insertSelective(TxUser txUser);

    TxUser selectLoginByLoginNamePwd(String loginName, String pwd);

    TxUser selectUserByIdAndToken(int userId, String userToken);

    int updateByUser(TxUser txUser);

    int updateByPrimaryKeySelective(TxUser txUser);

    boolean validateUserByIdTokenPwd(int userId, String userToken, String password);

    TxUser selectUserByToken(String userToken);

    List<TxUser> selectUserByDeviceId(int deviceId);
}
