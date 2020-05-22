package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.mapper.*;
import com.aw.braceletserver.entity.*;
import com.aw.braceletserver.service.DeviceManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DeviceManagerServiceImpl implements DeviceManagerService {

    private Logger logger = LoggerFactory.getLogger(DeviceManagerServiceImpl.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Resource
    TxUserMapper txUserMapper;
    @Resource
    DeviceMapper deviceMapper;

    @Resource
    UserGroupMapper userGroupMapper;

    @Resource
    DevicePositionMapper devicePositionMapper;

    @Resource
    HealthMapper healthMapper;

    @Override
    public Integer selectMaxDevicePositionId() {
        return devicePositionMapper.selectMaxDevicePositionId();
    }
    @Override
    public Integer selectMaxDeviceId() {
        return deviceMapper.selectMaxDeviceId();
    }
    @Override
    public Device getDeviceByImei(String serialNumber) {
        return deviceMapper.selectByPrimaryKey(serialNumber);
    }

    @Override
    public Device updateDevice(Device device) {
        logger.info("device = {}", JSONObject.toJSONString(device));
        deviceMapper.updateByPrimaryKeySelective(device);
        return device;
    }

    @Override
    public Device getDeviceByDeviceId(int deviceId) {
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria deviceCriteria = deviceExample.createCriteria();
        deviceCriteria.andDeviceIdEqualTo(deviceId);
        deviceExample.setOrderByClause("CREATE_TIME DESC");
        List<Device> deviceList = deviceMapper.selectByExample(deviceExample);
        if (deviceList == null || deviceList.size() == 0) return null;
        return deviceList.get(0);
    }

    @Override
    public boolean validateBindDeviceByUserId(int userId) {
        List<UserGroup> userGroupList = selectByUserId(userId);
        if (userGroupList == null || userGroupList.size() < 1) return false;
        return true;
    }

    @Override
    public boolean validateBindDeviceByDeviceId(int deviceId) {
        List<UserGroup> userGroupList = selectByDeviceId(deviceId);
        if (userGroupList == null || userGroupList.size() < 1) return false;
        return true;
    }

    @Override
    public boolean validateBindDeviceToUser(int userId, int deviceId) {
        UserGroupExample userGroupExample = new UserGroupExample();
        UserGroupExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        userGroupExample.setOrderByClause("CREATE_TIME DESC");
        List<UserGroup> userGroupList = userGroupMapper.selectByExample(userGroupExample);
        if (userGroupList == null || userGroupList.size() == 0) return false;
        return true;
    }

    @Override
    public boolean validateBindDeviceToUserRole(int userId, int deviceId, int groupId) {
        UserGroupExample userGroupExample = new UserGroupExample();
        UserGroupExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andGroupIdEqualTo(groupId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        List<UserGroup> userGroupList = userGroupMapper.selectByExample(userGroupExample);
        if (userGroupList == null || userGroupList.size() == 0) return false;
        return true;
    }

    @Override
    public int bindDeviceToUserRole(int userId, int deviceId, int groupId) {
        logger.info("userId = {}, deviceId = {}, groupId = {}", userId, deviceId, groupId);
        if(validateBindDeviceToUserRole(userId, deviceId, groupId)){
            return 0;
        }
        Integer maxNo = userGroupMapper.selectMaxNo();
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId((maxNo == null)? 0: maxNo + 1);
        userGroup.setUserId(userId);
        userGroup.setDeviceId(deviceId);
        userGroup.setCreateTime(new Date());
        userGroup.setStatus(1);
        return userGroupMapper.insertSelective(userGroup);
    }
    
    @Override
    public int bindDeviceToUserRole(int userId, int deviceId) {
        logger.info("新增userGroup: userId = {}, deviceId = {}", userId, deviceId);
        //Integer maxNo = userGroupMapper.selectMaxNo();
        UserGroup userGroup = new UserGroup();
        //userGroup.setGroupId((maxNo == null)? 0: maxNo + 1);
        userGroup.setGroupId(101);
        userGroup.setUserId(userId);
        userGroup.setDeviceId(deviceId);
        userGroup.setCreateTime(new Date());
        userGroup.setStatus(1);
        return userGroupMapper.insertSelective(userGroup);
    }

    @Override
    public int unbindDeviceToUserRole(int userId, int deviceId, int groupId) {
        logger.info("userId = {}, deviceId = {}, groupId = {}", userId, deviceId, groupId);
        if(!validateBindDeviceToUserRole(userId, deviceId, groupId)){
            return 0;
        }
        UserGroupExample userGroupExample = new UserGroupExample();
        UserGroupExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andGroupIdEqualTo(groupId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        UserGroup userGroup = new UserGroup();
        userGroup.setStatus(2);
        return userGroupMapper.updateByExampleSelective(userGroup, userGroupExample);
    }

    @Override
    public List<Device> getDeviceByUserId(int userId) {
        return deviceMapper.selectDeviceByUserId(userId);
    }

    @Override
    public DevicePosition getLastedDevicePositionByDeviceId(int deviceId) {
        DevicePositionExample devicePositionExample = new DevicePositionExample();
        DevicePositionExample.Criteria criteria = devicePositionExample.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);
        devicePositionExample.setOrderByClause("device_utc_time desc");
        List<DevicePosition> devicePositionList = devicePositionMapper.selectByExample(devicePositionExample);
        if (devicePositionList == null || devicePositionList.size() == 0) return new DevicePosition();
        return devicePositionList.get(0);
    }

    @Override
    public List<DevicePosition> getHistoryLocation(int deviceId, int userId, int selectCount, String startTime, String endTime) throws Exception{
        DevicePositionExample devicePositionExample = new DevicePositionExample();
        DevicePositionExample.Criteria criteria = devicePositionExample.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);
        criteria.andDeviceUtcTimeGreaterThanOrEqualTo(sdf.parse(startTime));
        criteria.andDeviceUtcTimeLessThanOrEqualTo(sdf.parse(endTime));
        if (selectCount <= 0) devicePositionExample.setOrderByClause("device_utc_time desc");
        else devicePositionExample.setOrderByClause("device_utc_time desc limit 0," + selectCount);
        return devicePositionMapper.selectByExample(devicePositionExample);
    }

    @Override
    public List<Map<String, Object>> selectAllDeviceData() {
        return txUserMapper.selectAllDeviceData();
    }

    @Override
    public List<Health> selectUserDeviceData(int userId, String deviceSerialNumber, Date startTime) throws Exception{
        HealthExample healthExample = new HealthExample();
        HealthExample.Criteria criteria = healthExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDeviceSerialNumEqualTo(deviceSerialNumber);
        criteria.andCreateTimeGreaterThanOrEqualTo(sdf.parse("2019-11-25 08:49:38"));
        healthExample.setOrderByClause("create_time asc");
        return healthMapper.selectByExample(healthExample);
    }

    @Override
    public List<UserGroup>  selectByUserId(int userId) {
        UserGroupExample userGroupExample = new UserGroupExample();
        UserGroupExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        userGroupExample.setOrderByClause("CREATE_TIME DESC");
        return userGroupMapper.selectByExample(userGroupExample);
    }

    @Override
    public List<UserGroup>  selectByDeviceId(int deviceId) {
        UserGroupExample userGroupExample = new UserGroupExample();
        UserGroupExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        userGroupExample.setOrderByClause("CREATE_TIME DESC");
        return userGroupMapper.selectByExample(userGroupExample);
    }

    @Override
    public DevicePosition addDevicePosition(DevicePosition devicePosition) {
        //logger.info("devicePosition = {}", JSONObject.toJSONString(devicePosition));
        devicePositionMapper.insertSelective(devicePosition);
        return devicePosition;
    }
    @Override
    public Device addDevice(Device device) {
    	device.setStatus("1");
        device.setCreateTime(new Date());
        logger.info("新增设备 = {}", JSONObject.toJSONString(device));
        deviceMapper.insertSelective(device);
        return device;
    }
}
