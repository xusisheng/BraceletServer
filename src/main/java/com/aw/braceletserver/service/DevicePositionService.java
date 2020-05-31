package com.aw.braceletserver.service;

import com.aw.braceletserver.model.DevicePosition;

import java.util.List;

public interface DevicePositionService {

    /**
     * 插入
     * @param entity
     * @return
     */
    long insert(DevicePosition entity);

    /**
     * 依据设备ID查询最后N个位置记录
     *
     * @param deviceId
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    List<DevicePosition> getLastedNDevicePositionByDeviceId(Long deviceId, String startTime, String endTime, Integer limit);
}
