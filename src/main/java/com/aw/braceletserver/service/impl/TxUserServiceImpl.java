package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.aw.braceletserver.mapper.TxUserMapper;
import com.aw.braceletserver.model.TxUser;
import com.aw.braceletserver.model.TxUserExample;
import com.aw.braceletserver.service.TxUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TxUserServiceImpl implements TxUserService {
    Logger logger = LoggerFactory.getLogger(TxUserServiceImpl.class);

    @Resource
    TxUserMapper txUserMapper;

    @Override
    public TxUser getUserByUserId(int userId) {
        logger.info("userId = {}", userId);
        return txUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Integer selectMaxUserId() {
        return txUserMapper.selectMaxId();
    }

    @Override
    public long countByExample(TxUserExample example) {
        logger.info("example = {}", JSON.toJSONString(example));
        return txUserMapper.countByExample(example);
    }

    @Override
    public int insertSelective(TxUser txUser) {
        logger.info("txUser = {}", JSON.toJSONString(txUser));
        return txUserMapper.insertSelective(txUser);
    }

    @Override
    public TxUser selectLoginByLoginNamePwd(String loginName, String pwd) {
        logger.info("loginName = {}, pwd = {}", loginName, pwd);
        TxUserExample example=new TxUserExample();
        example.createCriteria().andLoginNameEqualTo(loginName);
        example.createCriteria().andPasswordEqualTo(pwd);
        List<TxUser> userList = txUserMapper.selectByExample(example);
        if (userList == null || userList.size() == 0) return null;
        return userList.get(0);
    }

    @Override
    public TxUser selectUserByIdAndToken(int userId, String userToken) {
        logger.info("userId = {}, userToken = {}", userId, userToken);
        TxUserExample example=new TxUserExample();
        example.createCriteria().andUserIdEqualTo(userId).andTokenEqualTo(userToken);
        List<TxUser> userList = txUserMapper.selectByExample(example);
        if (userList == null || userList.size() == 0) return null;
        return userList.get(0);
    }

    @Override
    public int updateByUser(TxUser txUser) {
        logger.info("user = {}", JSON.toJSONString(txUser));
        TxUserExample example=new TxUserExample();
        example.createCriteria().andUserIdEqualTo(txUser.getUserId());
        example.createCriteria().andTokenEqualTo(txUser.getToken());

        TxUser updateUser = new TxUser();
        if (StringUtils.isNotBlank(txUser.getUserName())) updateUser.setUserName(txUser.getUserName());
        if (StringUtils.isNotBlank(txUser.getEmail())) updateUser.setEmail(txUser.getEmail());
        if (StringUtils.isNotBlank(txUser.getCellphone())) updateUser.setCellphone(txUser.getCellphone());
        if (StringUtils.isNotBlank(txUser.getAddress())) updateUser.setAddress(txUser.getAddress());
        if (StringUtils.isNotBlank(txUser.getSex())) updateUser.setSex(txUser.getSex());
        if (StringUtils.isNotBlank(txUser.getPassword())) updateUser.setSex(txUser.getPassword());

        return txUserMapper.updateByExampleSelective(updateUser, example);
    }

    @Override
    public int updateByPrimaryKeySelective(TxUser txUser) {
        logger.info("txUser = {}", JSON.toJSONString(txUser));
        return txUserMapper.updateByPrimaryKeySelective(txUser);
    }

    @Override
    public boolean validateUserByIdTokenPwd(int userId, String userToken, String password) {
        logger.info("userId = {}, userToken = {}, password = {}", userId, userToken, password);
        TxUserExample example=new TxUserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.createCriteria().andTokenEqualTo(userToken);
        example.createCriteria().andPasswordEqualTo(password);
        List<TxUser> userList = txUserMapper.selectByExample(example);
        if (userList == null || userList.size() == 0) return false;
        return true;
    }

    @Override
    public TxUser selectUserByToken(String userToken) {
        TxUserExample example=new TxUserExample();
        example.createCriteria().andTokenEqualTo(userToken);
        List<TxUser> userList = txUserMapper.selectByExample(example);
        if (userList == null || userList.size() == 0) return null;
        return userList.get(0);
    }

    @Override
    public List<TxUser> selectUserByDeviceId(int deviceId) {
        logger.info("deviceId = {}", deviceId);
        TxUserExample example=new TxUserExample();
        example.createCriteria().andDeviceIdEqualTo(deviceId);
        List<TxUser> userList = txUserMapper.selectByExample(example);
        return userList;
    }


}
