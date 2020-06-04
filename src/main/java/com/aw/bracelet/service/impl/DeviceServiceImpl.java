package com.aw.bracelet.service.impl;

import com.aw.bracelet.mapper.*;
import com.aw.bracelet.model.*;
import com.aw.bracelet.service.DeviceService;
import com.aw.bracelet.utils.TypeChecker;
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
    public Device getDeviceByIdcode(String idcode) {
        DeviceExample example = new DeviceExample();
        DeviceExample.Criteria criteria = example.createCriteria();
        criteria.andIdcodeEqualTo(idcode);
        List<Device> listDevice = deviceMapper.selectByExample(example);
        if (TypeChecker.isEmpty(listDevice)) {
            logger.warn("Idcode[{}] not exists!!", idcode);
            return null;
        }
        return listDevice.get(0);
    }

    @Override
    public Device getDeviceBySn(String rfid) {
        DeviceExample example = new DeviceExample();
        DeviceExample.Criteria criteria = example.createCriteria();
        criteria.andSnEqualTo(rfid);
        List<Device> listDevice = deviceMapper.selectByExample(example);
        if (TypeChecker.isEmpty(listDevice)) {
            logger.warn("RFID[{}] not exists!!", rfid);
            return null;
        }
        return listDevice.get(0);
    }

    @Override
    public List<Device> selectBySnSet(Long userId, String[] sns) {
        return deviceMapper.selectBySnSet(userId, sns);
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
