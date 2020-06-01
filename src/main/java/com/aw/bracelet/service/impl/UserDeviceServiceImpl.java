package com.aw.bracelet.service.impl;

import com.aw.bracelet.mapper.UserDeviceMapper;
import com.aw.bracelet.model.UserDevice;
import com.aw.bracelet.service.UserDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeviceServiceImpl implements UserDeviceService {
    private static final Logger logger = LoggerFactory.getLogger(UserDeviceServiceImpl.class);

    @Autowired
    private UserDeviceMapper userDeviceMapper;

    @Override
    public int insert(UserDevice entity) {
        return userDeviceMapper.insert(entity);
    }

//    @Override
//    public List<UserDevice> selectBySnSet(Long userId, String[] ids) {
//        return userDeviceMapper.selectBySnSet(userId, ids);
//    }
}
