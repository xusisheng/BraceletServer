package com.aw.braceletserver.service;

import com.aw.braceletserver.constants.ResponseObject;

public interface TxDataService {

    /**
     * 验证用户存在
     * @param userId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateUserExistByUserId(int userId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证用户存在
     * @param userToken
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateUserExistByUserToken(String userToken, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证用户存在
     * @param userId
     * @param userToken
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateUserExistByUserIdAndToken(int userId, String userToken, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备存在
     * @param deviceSerialNum
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceExistByDeviceSerialNum(String deviceSerialNum, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备存在
     * @param deviceId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceExistByDeviceId(int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备是否存在
     * @param deviceSerialNum
     * @param deviceId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceExistByDeviceSerialNumOrDeviceId(String deviceSerialNum, int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备是否被绑定
     * @param deviceId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceBindByDeviceId(int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备属于用户
     * @param userId
     * @param deviceId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceBind2UserByUserIdAndDeviceId(int userId, int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备是否绑定到用户组
     * @param userId
     * @param deviceId
     * @param groupId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateBindDeviceToUserGroup(int userId, int deviceId, int groupId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 绑定设备到用户角色
     * @param userId
     * @param deviceId
     * @param groupId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean bindDeviceToUserRole(int userId, int deviceId, int groupId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 解绑用户角色设备
     * @param userId
     * @param deviceId
     * @param groupId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean unbindDeviceToUserRole(int userId, int deviceId, int groupId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     *  验证设备是否在线
     * @param deviceSerialNum
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceOnline(String deviceSerialNum, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备是否在线
     * @param deviceId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceOnline(int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject);

    /**
     * 验证设备是否在线
     * @param deviceSerialNum
     * @param deviceId
     * @param method
     * @param requestObject
     * @param responseObject
     * @return
     */
    boolean validateDeviceOnline(String deviceSerialNum, int deviceId, String method, ResponseObject requestObject, ResponseObject responseObject);


}
