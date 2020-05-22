package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.constants.Constant;
import com.aw.braceletserver.constants.ResponseObject;
import com.aw.braceletserver.mapper.DeviceGeofenceMapper;
import com.aw.braceletserver.entity.DeviceGeofence;
import com.aw.braceletserver.entity.DeviceGeofenceExample;
import com.aw.braceletserver.enums.StateEnum;
import com.aw.braceletserver.service.GeofenceManagerService;
import com.aw.braceletserver.service.TxDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GeofenceManagerServiceImpl implements GeofenceManagerService {

    Logger logger = LoggerFactory.getLogger(GeofenceManagerServiceImpl.class);

    @Autowired
    DeviceGeofenceMapper deviceGeofenceMapper;

    @Autowired
    TxDataService txDataService;

    @Override
    public int getNextGeofenceId() {
        return deviceGeofenceMapper.getNextGeofenceId();
    }

    @Override
    public List<DeviceGeofence> getListByDeviceId(int deviceId) {
        logger.info("deviceId = {}", deviceId);
        DeviceGeofenceExample deviceGeofenceExample = new DeviceGeofenceExample();
        DeviceGeofenceExample.Criteria criteria = deviceGeofenceExample.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);
        return  deviceGeofenceMapper.selectByExample(deviceGeofenceExample);
    }

    @Override
    public DeviceGeofence createDeviceGeofence(JSONObject item) {
        logger.info("params = {}", item.toJSONString());
        Integer deviceId = item.getInteger(Constant.DeviceId);
        String latitude = item.getString(Constant.Latitude);
        String longitude = item.getString(Constant.Longitude);
        Integer radius = item.getInteger(Constant.Radius);
        Integer fenceType = item.getInteger(Constant.FenceType);
        Integer alarmType = item.getInteger(Constant.AlarmType);
        String address = item.getString(Constant.Address);
        String fenceName = item.getString(Constant.FenceName);

        DeviceGeofence insertRecord = new DeviceGeofence();
        insertRecord.setId(getNextGeofenceId());
        insertRecord.setName(fenceName);
        insertRecord.setLatitude(Double.parseDouble(latitude));
        insertRecord.setLongitude(Double.parseDouble(longitude));
        insertRecord.setRadius(radius);
        insertRecord.setFenceType(fenceType);
        insertRecord.setAlarmType(alarmType);
        insertRecord.setAddress(address);
        insertRecord.setDeviceId(deviceId);
        insertRecord.setCreateTime(new Date());
        deviceGeofenceMapper.insertSelective(insertRecord);
        return  insertRecord;
    }

    @Override
    public DeviceGeofence editDeviceGeofence(JSONObject item) {
        logger.info("params = {}", item.toJSONString());
        Integer fenceId = item.getInteger("FenceId");
        Integer deviceId = item.getInteger(Constant.DeviceId);
        String latitude = item.getString(Constant.Latitude);
        String longitude = item.getString(Constant.Longitude);
        Integer radius = item.getInteger(Constant.Radius);
        Integer fenceType = item.getInteger(Constant.FenceType);
        Integer alarmType = item.getInteger(Constant.AlarmType);
        String address = item.getString(Constant.Address);
        String fenceName = item.getString(Constant.FenceName);

        DeviceGeofence updateRecord = new DeviceGeofence();
        updateRecord.setId(fenceId);
        updateRecord.setName(fenceName);
        updateRecord.setLatitude(Double.parseDouble(latitude));
        updateRecord.setLongitude(Double.parseDouble(longitude));
        updateRecord.setRadius(radius);
        updateRecord.setFenceType(fenceType);
        updateRecord.setAlarmType(alarmType);
        updateRecord.setAddress(address);
        updateRecord.setDeviceId(deviceId);
        deviceGeofenceMapper.updateByPrimaryKeySelective(updateRecord);
        return  updateRecord;
    }

    @Override
    public boolean deleteDeviceGeofence(int userId, int fenceId, ResponseObject responseObject) {
        logger.info("userId = {}, fenceId = {}", userId, fenceId);
        DeviceGeofence deviceGeofence = deviceGeofenceMapper.selectByPrimaryKey(fenceId);
        if (deviceGeofence == null) {
            logger.info("安全区域不存在，fenceId = {}", fenceId);
            responseObject.setState(StateEnum.OTHER.getCode(), "安全区域不存在");
            return false;
        }

        if (!txDataService.validateDeviceBind2UserByUserIdAndDeviceId(userId, deviceGeofence.getDeviceId(), "删除安全区域",
                new ResponseObject(), responseObject)) return false;

        deviceGeofenceMapper.deleteByPrimaryKey(fenceId);
        return true;
    }
}
