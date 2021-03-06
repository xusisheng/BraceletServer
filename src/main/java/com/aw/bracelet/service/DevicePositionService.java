package com.aw.bracelet.service;

import com.aw.bracelet.model.DevicePosition;

import java.util.HashMap;
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

    /**
     * 依据用户ID和时间查询告警信息
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    List<HashMap<String, Object>> selectSosByUserIdTime(Long userId, String startTime, String endTime);
}
