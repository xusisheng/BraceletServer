package com.aw.braceletserver.service;

import com.aw.braceletserver.model.DeviceAlarmRecord;

import java.util.List;

public interface DeviceAlarmRecordService {

    /**
     * 查询报警记录
     * @param deviceId  设备id
     * @param selectCounts 查询条数
     * @return
     */
    List<DeviceAlarmRecord> selectRecordByDeviceId(int deviceId, int selectCounts);
}
