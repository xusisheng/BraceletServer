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
    public List<DevicePosition> getLastedNDevicePositionByDeviceId(Long deviceId, String startTime, String endTime, Integer limit) {
        return devicePositionMapper.getLastedNDevicePositionByDeviceId(deviceId, startTime, endTime, limit);
    }
}
