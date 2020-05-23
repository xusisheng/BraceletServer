package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.mapper.DeviceAlarmRecordMapper;
import com.aw.braceletserver.model.DeviceAlarmRecord;
import com.aw.braceletserver.service.DeviceAlarmRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceAlarmRecordServiceImpl implements DeviceAlarmRecordService {

    @Resource
    private DeviceAlarmRecordMapper deviceAlarmRecordMapper;

    @Override
    public List<DeviceAlarmRecord> selectRecordByDeviceId(int deviceId, int selectCounts) {
//        DeviceAlarmRecordExample deviceAlarmRecordExample = new DeviceAlarmRecordExample();
//        DeviceAlarmRecordExample.Criteria criteria = deviceAlarmRecordExample.createCriteria();
//        criteria.andDeviceIdEqualTo(deviceId);
//        if (selectCounts > 0){
//            deviceAlarmRecordExample.setOrderByClause("create_time desc limit " + selectCounts);
//        }
//        return deviceAlarmRecordMapper.selectByExample(deviceAlarmRecordExample);
        return null;
    }
}
