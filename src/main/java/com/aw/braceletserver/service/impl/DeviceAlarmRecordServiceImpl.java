package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.mapper.DeviceAlarmRecordMapper;
import com.aw.braceletserver.model.DeviceAlarmRecord;
import com.aw.braceletserver.model.DeviceAlarmRecordExample;
import com.aw.braceletserver.service.DeviceAlarmRecordService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceAlarmRecordServiceImpl implements DeviceAlarmRecordService {

    @Resource
    private DeviceAlarmRecordMapper deviceAlarmRecordMapper;

    @Override
    public List<DeviceAlarmRecord> selectRecordByDeviceId(int deviceId, int start, int selectCounts) {
        DeviceAlarmRecordExample deviceAlarmRecordExample = new DeviceAlarmRecordExample();
        deviceAlarmRecordExample.setOrderByClause("id");
        deviceAlarmRecordExample.createCriteria().andDeviceIdEqualTo(deviceId);
        //分页
        PageHelper.startPage(start, selectCounts);
        return deviceAlarmRecordMapper.selectByExample(deviceAlarmRecordExample);
    }

    @Override
    public List<Map<String, Object>> selectAlarmDeviceDataByUserId(int UserId, int start, String startTime, int selectCounts) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", UserId);
        map.put("startTime", startTime);
        return deviceAlarmRecordMapper.selectAlarmDeviceDataByUserId(map);
    }
}
