package com.aw.braceletserver.service;

import com.aw.braceletserver.model.Device;
import com.aw.braceletserver.model.DevicePosition;
import com.aw.braceletserver.model.UserDevice;

import java.util.List;
import java.util.Map;

public interface DeviceService {

    /**
     * 插入
     * @param entity
     * @return
     */
    long insert(Device entity);

    /**
     * 依据主键更新，NULL不更新
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(Device entity);

    /**
     * 依据IoT平台设备ID查询设备信息
     *
     * @param iotid
     * @return
     */
    Device getDeviceByIotid(String iotid);

    /**
     * 根据设备imei唯一标识获取设备信息
     * @param serialNumber
     * @return
     */
    Device getDeviceByImei(String serialNumber);
    /**
     * 根据设备id获取设备信息
     * @param deviceId
     * @return
     */
    Device getDeviceByDeviceId(long deviceId);
    /**
     * 验证设备是否被绑定
     * @param userId
     * @return
     */
    boolean validateBindDeviceByUserId(long userId);

    /**
     * 验证设备是否被绑定
     * @param deviceId
     * @return
     */
    boolean validateBindDeviceByDeviceId(long deviceId);

    /**
     * 验证设备是否属于用户
     * @param userId
     * @param deviceId
     * @return
     */
    boolean validateBindDeviceToUser(long userId, long deviceId);

    /**
     * 验证设备是否绑定到用户角色下
     * @param userId
     * @param deviceId
     * @param groupId
     * @return
     */
    boolean validateBindDeviceToUserRole(long userId, long deviceId, int groupId);

    /**
     * 绑定设备到用户角色下
     * @param userId
     * @param deviceId
     * @param groupId
     * @return
     */
    int bindDeviceToUserRole(long userId, long deviceId, int groupId);
    
    int bindDeviceToUserRole(long userId, long deviceId);

    /**
     * 解绑用户角色下的设备
     * @param userId
     * @param deviceId
     * @param groupId
     * @return
     */
    int unbindDeviceToUserRole(long userId, long deviceId, int groupId);

    /**
     * 根据userid获取用户设备
     * @param userId
     * @return
     */
    List<Device> getDeviceByUserId(long userId);

    /**
     * 获取最新的设备定位
     * @param deviceId
     * @return
     */
    DevicePosition getLastedDevicePositionByDeviceId(long deviceId);

    /**
     * 获取设备历史定位信息
     * @param deviceId
     * @param userId
     * @param selectCount 获取条数
     * @param startTime
     * @param endTime
     * @return
     */
    List<DevicePosition> getHistoryLocation(long deviceId, long userId, int selectCount, String startTime, String endTime) throws Exception;

    /**
     * 查询所有设备实时信息
     * @return
     */
    List<Map<String, Object>> selectDeviceDataByUserId(long userId);

    /**
     * 查询用户绑定的设备关系
     * @param userId
     * @return
     */
    public List<UserDevice>  selectByUserId(long userId);

    /**
     * 查询设备绑定的设备关系
     * @param deviceId
     * @return
     */
    public List<UserDevice>  selectByDeviceId(long deviceId);
}
