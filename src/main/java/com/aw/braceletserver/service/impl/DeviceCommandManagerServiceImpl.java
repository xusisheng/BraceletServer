package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.aw.braceletserver.constants.ResponseObject;
import com.aw.braceletserver.mapper.DeviceCommandMapper;
import com.aw.braceletserver.entity.DeviceCommand;
import com.aw.braceletserver.entity.DeviceCommandExample;
import com.aw.braceletserver.enums.CommandEnum;
import com.aw.braceletserver.service.DeviceCommandManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceCommandManagerServiceImpl implements DeviceCommandManagerService {

    Logger logger = LoggerFactory.getLogger(DeviceCommandManagerServiceImpl.class);

    @Autowired
    DeviceCommandMapper deviceCommandMapper;


    @Override
    public int selectNextId() {
        return deviceCommandMapper.selectNextId();
    }

    @Override
    public boolean saveCommand(int deviceId, String deviceModel, CommandEnum commandEnum, String params, ResponseObject responseObject) {
        logger.info("deviceId = {}, deviceModel = {}, commandEnum = {}, params = {}, selectCounts = {}", deviceId, deviceModel, JSON.toJSONString(commandEnum), params, responseObject);
        //如果已经存在记录，则更新数据
        DeviceCommandExample deviceCommandExample = new DeviceCommandExample();
        DeviceCommandExample.Criteria criteria = deviceCommandExample.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);
        criteria.andCmdCodeEqualTo(commandEnum.getCode());
        List<DeviceCommand> deviceCommandList = deviceCommandMapper.selectByExample(deviceCommandExample);
        if (deviceCommandList != null && deviceCommandList.size() > 0){
            DeviceCommand updateCommand = new DeviceCommand();
            updateCommand.setId(deviceCommandList.get(0).getId());
            updateCommand.setDeviceModel(Integer.parseInt(deviceModel));
            updateCommand.setCmdValue(params);
            updateCommand.setUpdateTime(new Date());
            deviceCommandMapper.updateByPrimaryKeySelective(updateCommand);
            return true;
        }
        DeviceCommand insertCommand = new DeviceCommand();
        insertCommand.setId(selectNextId());
        insertCommand.setDeviceId(deviceId);
        insertCommand.setDeviceModel(Integer.parseInt(deviceModel));
        insertCommand.setCmdCode(commandEnum.getCode());
        insertCommand.setCmdName(commandEnum.getDesc());
        insertCommand.setCmdValue(params);
        insertCommand.setSmsType("0");
        insertCommand.setSmsContent("");
        insertCommand.setCreateTime(new Date());
        deviceCommandMapper.insert(insertCommand);
        return true;
    }

    @Override
    public List<DeviceCommand> getCommandList(int deviceId) {
        logger.info("deviceId = {}", deviceId);
        DeviceCommandExample deviceCommandExample = new DeviceCommandExample();
        DeviceCommandExample.Criteria criteria = deviceCommandExample.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);
        List<DeviceCommand> deviceCommandList = deviceCommandMapper.selectByExample(deviceCommandExample);
        return deviceCommandList;
    }
}
