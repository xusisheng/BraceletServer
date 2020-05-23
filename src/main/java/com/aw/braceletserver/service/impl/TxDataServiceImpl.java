package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.aw.braceletserver.constants.ResponseObject;
import com.aw.braceletserver.enums.StateEnum;
import com.aw.braceletserver.model.Device;
import com.aw.braceletserver.model.TxUser;
import com.aw.braceletserver.model.UserGroup;
import com.aw.braceletserver.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TxDataServiceImpl implements TxDataService {

    private Logger logger = LoggerFactory.getLogger(TxDataServiceImpl.class);

    @Resource
    protected TxUserService txUserService;
    @Resource
    protected DeviceManagerService deviceManagerService;
    @Resource
    protected HealthManagerService healthManagerService;

    public boolean validateUserExistByUserId(int userId, String method, ResponseObject requestObject, ResponseObject responseObject){
        return validateUserExistByUserIdAndToken(userId, null, method, requestObject, responseObject);
    }

    public boolean validateUserExistByUserToken(String userToken, String method, ResponseObject requestObject, ResponseObject responseObject){
        return validateUserExistByUserIdAndToken(-1, userToken, method, requestObject, responseObject);
    }

    public boolean validateUserExistByUserIdAndToken(int userId, String userToken, String method, ResponseObject requestObject, ResponseObject responseObject){
        //用户是否存在
        TxUser user = null;
        if (userId == -1 && StringUtils.isNotBlank(userToken)){
            user = txUserService.selectUserByToken(userToken);
        }
        if (userId != -1 && StringUtils.isBlank(userToken)){
            user = txUserService.getUserByUserId(userId);
        }
        if (userId != -1 && StringUtils.isNotBlank(userToken)){
            user = txUserService.selectUserByIdAndToken(userId, userToken);
        }
        if(user == null) {
            responseObject.setState(StateEnum.USER_NOT_EXIST);
            String responseStr = responseObject.toJSONString();
            logger.info("method = {}, response: {}", method, responseStr);
            return false;
        }
        requestObject.setObject("TxUser", user);
        return true;
    }

    public boolean validateDeviceExistByDeviceSerialNum(String deviceSerialNum, String method, ResponseObject requestObject, ResponseObject responseObject){
        return validateDeviceExistByDeviceSerialNumOrDeviceId(deviceSerialNum, -1, method, requestObject, responseObject);
    }

    public boolean validateDeviceExistByDeviceId(int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject){
        return validateDeviceExistByDeviceSerialNumOrDeviceId(null, deviceId, method, requestObject, responseObject);
    }

    public boolean validateDeviceExistByDeviceSerialNumOrDeviceId(String deviceSerialNum, int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject){
        //设备是否存在
        Device device = null;
        if (deviceId == -1 && StringUtils.isNotBlank(deviceSerialNum)){
            device = deviceManagerService.getDeviceByImei(deviceSerialNum);
        }
        if (deviceId != -1 && StringUtils.isBlank(deviceSerialNum)){
            device = deviceManagerService.getDeviceByDeviceId(deviceId);
        }
//        if (deviceId != -1 && StringUtils.isNotBlank(deviceSerialNum)){
//            device = deviceManagerService.selectUserByIdAndToken(userId, userToken);
//        }
        if(device == null) {
            responseObject.setState(StateEnum.DEVICE_NOT_EXIST);
            String responseStr = responseObject.toJSONString();
            logger.info("method = {}, response: {}", method, responseStr);
            return false;
        }
        requestObject.setObject("Device", device);
        return true;
    }

    @Override
    public boolean validateDeviceBindByDeviceId(int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject) {
        List<UserGroup> userGroupList = deviceManagerService.selectByDeviceId(deviceId);
        //设备是否绑定
        if(userGroupList == null || userGroupList.size() == 0) return true;
        return false;

    }

    public boolean validateDeviceBind2UserByUserIdAndDeviceId(int userId, int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject){
        //设备是否绑定
        if(!deviceManagerService.validateBindDeviceToUser(userId, deviceId)){
            responseObject.setState(StateEnum.OTHER.getCode(), "设备不属于自己");
            String responseStr = responseObject.toJSONString();
            logger.info("method = {}, response: {}", method, responseStr);
            return false;
        }
        return true;
    }

    @Override
    public boolean validateBindDeviceToUserGroup(int userId, int deviceId, int groupId, String method, ResponseObject requestObject, ResponseObject responseObject) {
        //logger.info("method = {}, userId = {}, deviceId = {}, groupId = {}, requestObject = {}, responseObject = {}", method, userId, deviceId, groupId, JSON.toJSONString(requestObject), JSON.toJSONString(responseObject));
        //设备是否绑定到角色
        if(!deviceManagerService.validateBindDeviceToUserRole(userId, deviceId, groupId)){
            responseObject.setState(StateEnum.OTHER.getCode(), "该设备未被绑定到用户下");
            String responseStr = responseObject.toJSONString();
            logger.info("method = {}, response: {}", method, responseStr);
            return false;
        }
        return true;
    }

    @Override
    public boolean bindDeviceToUserRole(int userId, int deviceId, int groupId, String method, ResponseObject requestObject, ResponseObject responseObject) {
        logger.info("method = {}, userId = {}, deviceId = {}, groupId = {}, requestObject = {}, responseObject = {}", method, userId, deviceId, groupId, JSON.toJSONString(requestObject), JSON.toJSONString(responseObject));
        deviceManagerService.bindDeviceToUserRole(userId, deviceId, groupId);

        responseObject.setState(StateEnum.SUCCESS);
        String responseStr = responseObject.toJSONString();
        logger.info("method = {}, response: {}", method, responseStr);
        return false;
    }

    @Override
    public boolean unbindDeviceToUserRole(int userId, int deviceId, int groupId, String method, ResponseObject requestObject, ResponseObject responseObject) {
        logger.info("method = {}, userId = {}, deviceId = {}, groupId = {}, requestObject = {}, responseObject = {}", method, userId, deviceId, groupId, JSON.toJSONString(requestObject), JSON.toJSONString(responseObject));
        int unbindCount = deviceManagerService.unbindDeviceToUserRole(userId, deviceId, groupId);
        responseObject.setState(StateEnum.SUCCESS);
        String responseStr = responseObject.toJSONString();
        logger.info("method = {}, response: {}", method, responseStr);
        return true;
    }

    @Override
    public boolean validateDeviceOnline(String deviceSerialNum, String method, ResponseObject requestObject, ResponseObject responseObject) {
        return validateDeviceOnline(deviceSerialNum, -1, method, requestObject, responseObject);
    }

    @Override
    public boolean validateDeviceOnline(int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject) {
        return validateDeviceOnline(null, deviceId, method, requestObject, responseObject);
    }

    @Override
    public boolean validateDeviceOnline(String deviceSerialNum, int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject) {
        logger.info("method = {}, deviceSerialNum = {}, deviceId = {}, requestObject = {}, responseObject = {}", method, deviceSerialNum, deviceId, JSON.toJSONString(requestObject), JSON.toJSONString(responseObject));
        Device device = null;
        if (StringUtils.isNotBlank(deviceSerialNum)){
            device = deviceManagerService.getDeviceByImei(deviceSerialNum);
        }
        if (StringUtils.isBlank(deviceSerialNum) && deviceId != -1){
            device = deviceManagerService.getDeviceByDeviceId(deviceId);
        }
        if (device == null){
            responseObject.setState(StateEnum.DEVICE_NOT_EXIST);
            return false;
        }
        if (3 ==  device.getStatus()){
            responseObject.setState(StateEnum.DEVICE_OFFLINE);
            return false;
        }
        requestObject.setObject("Device", device);
        return true;
    }
}
