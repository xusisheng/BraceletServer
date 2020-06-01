package com.aw.braceletserver.service;

import com.aw.braceletserver.model.DevicePosition;
import org.apache.ibatis.annotations.Param;

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
    List<DevicePosition> getLastestNByDeviceId(Long deviceId, String startTime, String endTime, Integer limit);

    /**
     * 依据设备ID列表查询最后位置记录
     * @param userId
     * @param sns
     * @return
     */
    List<DevicePosition> selectLastestBySnSet(Long userId, String[] sns);

    /**
     * 依据用户ID列表查询最后位置记录
     * @param userId
     * @return
     */
    List<DevicePosition> selectLastestByUserId(Long userId);
}
