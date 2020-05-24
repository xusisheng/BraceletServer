package com.aw.braceletserver.service;

import com.aw.braceletserver.model.DeviceAlarmRecord;

import java.util.List;
import java.util.Map;

public interface DeviceAlarmRecordService {

    /**
     * 查询报警记录
     * @param deviceId  设备id
     * @param start 开始记录数
     * @param selectCounts 查询条数
     * @return
     */
    List<DeviceAlarmRecord> selectRecordByDeviceId(int deviceId, int start, int selectCounts);

    /**
     * 分页查询设备告警记录
     *
     * @param UserId 用户ID
     * @param start 开始记录数
     * @param startTime 告警开始时间
     * @param selectCounts 查询条数
     * @return
     */
    List<Map<String, Object>> selectAlarmDeviceDataByUserId(int UserId, int start, String startTime, int selectCounts);
}
