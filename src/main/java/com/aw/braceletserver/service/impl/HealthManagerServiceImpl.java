package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.mapper.HealthMapper;
import com.aw.braceletserver.model.Health;
import com.aw.braceletserver.model.HealthExample;
import com.aw.braceletserver.service.HealthManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HealthManagerServiceImpl implements HealthManagerService {

    @Resource
    HealthMapper healthMapper;

    @Override
    public Health addHealth(Health health) {
        healthMapper.insertSelective(health);
        return health;
    }

    @Override
    public List<Health> getHealthByUserDevice(int userId, String deviceSerialNum, Date startTime, Date endTime) {
        HealthExample healthExample = new HealthExample();
        HealthExample.Criteria criteria = healthExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDeviceSerialNumEqualTo(deviceSerialNum);
        criteria.andCreateTimeGreaterThanOrEqualTo(startTime);
        criteria.andCreateTimeLessThanOrEqualTo(endTime);
        return healthMapper.selectByExample(healthExample);
    }
}
