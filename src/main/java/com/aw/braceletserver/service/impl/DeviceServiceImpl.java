package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.mapper.*;
import com.aw.braceletserver.model.*;
import com.aw.braceletserver.service.DeviceService;
import com.aw.braceletserver.utils.TypeChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService {

    private static final Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    DeviceMapper deviceMapper;
    @Resource
    UserDeviceMapper userDeviceMapper;
    @Resource
    DevicePositionMapper devicePositionMapper;

    @Override
    public long insert(Device entity) {
        return deviceMapper.insert(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(Device entity) {
        return deviceMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Device getDeviceByIotid(String iotid) {
        DeviceExample example = new DeviceExample();
        DeviceExample.Criteria criteria = example.createCriteria();
        criteria.andIotDeviceidEqualTo(iotid);
        List<Device> listDevice = deviceMapper.selectByExample(example);
        if (TypeChecker.isEmpty(listDevice)) {
            logger.warn("Iot Device ID[{}] not exists!!", iotid);
            return null;
        }
        return listDevice.get(0);
    }

    @Override
    public Device getDeviceByImei(String serialNumber) {
        //TODO
        return deviceMapper.selectByPrimaryKey(0L);
    }

    @Override
    public Device getDeviceByDeviceId(long deviceId) {
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria deviceCriteria = deviceExample.createCriteria();
//        deviceCriteria.andDeviceIdEqualTo(deviceId);
        deviceExample.setOrderByClause("CREATE_TIME DESC");
        List<Device> deviceList = deviceMapper.selectByExample(deviceExample);
        if (deviceList == null || deviceList.size() == 0) return null;
        return deviceList.get(0);
    }

    @Override
    public boolean validateBindDeviceByUserId(long userId) {
        List<UserDevice> userGroupList = selectByUserId(userId);
        if (userGroupList == null || userGroupList.size() < 1) return false;
        return true;
    }

    @Override
    public boolean validateBindDeviceByDeviceId(long deviceId) {
        List<UserDevice> userGroupList = selectByDeviceId(deviceId);
        if (userGroupList == null || userGroupList.size() < 1) return false;
        return true;
    }

    @Override
    public boolean validateBindDeviceToUser(long userId, long deviceId) {
        UserDeviceExample userGroupExample = new UserDeviceExample();
        UserDeviceExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        userGroupExample.setOrderByClause("CREATE_TIME DESC");
        List<UserDevice> userGroupList = userDeviceMapper.selectByExample(userGroupExample);
        if (userGroupList == null || userGroupList.size() == 0) return false;
        return true;
    }

    @Override
    public boolean validateBindDeviceToUserRole(long userId, long deviceId, int groupId) {
        UserDeviceExample userGroupExample = new UserDeviceExample();
        UserDeviceExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andGroupIdEqualTo(groupId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        List<UserDevice> userGroupList = userDeviceMapper.selectByExample(userGroupExample);
        if (userGroupList == null || userGroupList.size() == 0) return false;
        return true;
    }

    @Override
    public int bindDeviceToUserRole(long userId, long deviceId, int groupId) {
        logger.info("userId = {}, deviceId = {}, groupId = {}", userId, deviceId, groupId);
        if (validateBindDeviceToUserRole(userId, deviceId, groupId)) {
            return 0;
        }
//        Integer maxNo = userDeviceMapper.selectMaxNo();
        UserDevice userGroup = new UserDevice();
//        userGroup.setGroupId((maxNo == null)? 0: maxNo + 1);
        userGroup.setUserId(userId);
        userGroup.setDeviceId(deviceId);
        userGroup.setCreateTime(new Date());
        userGroup.setStatus(1);
        return userDeviceMapper.insertSelective(userGroup);
    }

    @Override
    public int bindDeviceToUserRole(long userId, long deviceId) {
        logger.info("新增userGroup: userId = {}, deviceId = {}", userId, deviceId);
        //Integer maxNo = userGroupMapper.selectMaxNo();
        UserDevice userGroup = new UserDevice();
        //userGroup.setGroupId((maxNo == null)? 0: maxNo + 1);
        userGroup.setGroupId(101);
        userGroup.setUserId(userId);
        userGroup.setDeviceId(deviceId);
        userGroup.setCreateTime(new Date());
        userGroup.setStatus(1);
        return userDeviceMapper.insertSelective(userGroup);
    }

    @Override
    public int unbindDeviceToUserRole(long userId, long deviceId, int groupId) {
        logger.info("userId = {}, deviceId = {}, groupId = {}", userId, deviceId, groupId);
        if (!validateBindDeviceToUserRole(userId, deviceId, groupId)) {
            return 0;
        }
        UserDeviceExample userGroupExample = new UserDeviceExample();
        UserDeviceExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andGroupIdEqualTo(groupId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        UserDevice userGroup = new UserDevice();
        userGroup.setStatus(2);
        return userDeviceMapper.updateByExampleSelective(userGroup, userGroupExample);
    }

    @Override
    public List<Device> getDeviceByUserId(long userId) {
//        return deviceMapper.selectDeviceByUserId(userId);
        return null;
    }

    @Override
    public DevicePosition getLastedDevicePositionByDeviceId(long deviceId) {
        DevicePositionExample devicePositionExample = new DevicePositionExample();
        DevicePositionExample.Criteria criteria = devicePositionExample.createCriteria();
//        criteria.andDeviceIdEqualTo(deviceId);
        devicePositionExample.setOrderByClause("device_utc_time desc");
        List<DevicePosition> devicePositionList = devicePositionMapper.selectByExample(devicePositionExample);
        if (devicePositionList == null || devicePositionList.size() == 0) return new DevicePosition();
        return devicePositionList.get(0);
    }

    @Override
    public List<DevicePosition> getHistoryLocation(long deviceId, long userId, int selectCount, String startTime, String endTime) throws Exception {
        DevicePositionExample devicePositionExample = new DevicePositionExample();
        DevicePositionExample.Criteria criteria = devicePositionExample.createCriteria();
//        criteria.andDeviceIdEqualTo(deviceId);
//        criteria.andDeviceUtcTimeGreaterThanOrEqualTo(sdf.parse(startTime));
//        criteria.andDeviceUtcTimeLessThanOrEqualTo(sdf.parse(endTime));
        if (selectCount <= 0) devicePositionExample.setOrderByClause("device_utc_time desc");
        else devicePositionExample.setOrderByClause("device_utc_time desc limit 0," + selectCount);
        return devicePositionMapper.selectByExample(devicePositionExample);
    }

    @Override
    public List<Map<String, Object>> selectDeviceDataByUserId(long userId) {
//        return txUserMapper.selectDeviceDataByUserId(userId);
        return null;
    }

    @Override
    public List<UserDevice> selectByUserId(long userId) {
        UserDeviceExample userGroupExample = new UserDeviceExample();
        UserDeviceExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andUserIdEqualTo(userId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        userGroupExample.setOrderByClause("CREATE_TIME DESC");
        return userDeviceMapper.selectByExample(userGroupExample);
    }

    @Override
    public List<UserDevice> selectByDeviceId(long deviceId) {
        UserDeviceExample userGroupExample = new UserDeviceExample();
        UserDeviceExample.Criteria userGroupCriteria = userGroupExample.createCriteria();
        userGroupCriteria.andDeviceIdEqualTo(deviceId);
        userGroupCriteria.andStatusEqualTo(1);//1绑定，2解绑
        userGroupExample.setOrderByClause("CREATE_TIME DESC");
        return userDeviceMapper.selectByExample(userGroupExample);
    }
}
