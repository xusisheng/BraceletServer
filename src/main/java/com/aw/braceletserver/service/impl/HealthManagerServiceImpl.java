package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.mapper.HealthMapper;
import com.aw.braceletserver.entity.Health;
import com.aw.braceletserver.entity.HealthExample;
import com.aw.braceletserver.service.HealthManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
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
    public List<Health> getHealthByUserDevice(int userId, String deviceSerialNum, String startTime, String endTime) throws Exception{
        HealthExample healthExample = new HealthExample();
        HealthExample.Criteria criteria = healthExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDeviceSerialNumEqualTo(deviceSerialNum);
        criteria.andCreateTimeGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
        criteria.andCreateTimeLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
        return healthMapper.selectByExample(healthExample);
    }
}
