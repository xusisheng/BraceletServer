package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.mapper.UserDeviceMapper;
import com.aw.braceletserver.model.UserDevice;
import com.aw.braceletserver.service.UserDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDeviceServiceImpl implements UserDeviceService {
    private static final Logger logger = LoggerFactory.getLogger(UserDeviceServiceImpl.class);

    @Autowired
    private UserDeviceMapper userDeviceMapper;

    @Override
    public int insert(UserDevice entity) {
        return userDeviceMapper.insert(entity);
    }

    @Override
    public List<UserDevice> selectByIdSet(Long userId, Long[] ids) {
        return userDeviceMapper.selectByIdSet(userId, ids);
    }
}
