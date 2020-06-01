package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.mapper.DevicePositionMapper;
import com.aw.braceletserver.model.DevicePosition;
import com.aw.braceletserver.service.DevicePositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DevicePositionServiceImpl implements DevicePositionService {
    private static final Logger logger = LoggerFactory.getLogger(DevicePositionServiceImpl.class);

    @Resource
    private DevicePositionMapper devicePositionMapper;

    @Override
    public long insert(DevicePosition entity) {
        return devicePositionMapper.insert(entity);
    }

    @Override
    public List<DevicePosition> getLastestNByDeviceId(Long deviceId, String startTime, String endTime, Integer limit) {
        return devicePositionMapper.getLastestNByDeviceId(deviceId, startTime, endTime, limit);
    }

    @Override
    public List<DevicePosition> selectLastestBySnSet(Long userId, String[] sns) {
        return devicePositionMapper.selectLastestBySnSet(userId, sns);
    }

    @Override
    public List<DevicePosition> selectLastestByUserId(Long userId) {
        return devicePositionMapper.selectLastestByUserId(userId);
    }
}
