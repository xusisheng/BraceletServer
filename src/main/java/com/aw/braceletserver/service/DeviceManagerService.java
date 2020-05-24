package com.aw.braceletserver.service;

import com.aw.braceletserver.model.Device;
import com.aw.braceletserver.model.DevicePosition;
import com.aw.braceletserver.model.Health;
import com.aw.braceletserver.model.UserGroup;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DeviceManagerService {
    Integer selectMaxDevicePositionId();
    
    Integer selectMaxDeviceId();
    /**
     * 根据设备imei唯一标识获取设备信息
     * @param serialNumber
     * @return
     */
    Device getDeviceByImei(String serialNumber);

    Device updateDevice(Device device);
    /**
     * 根据设备id获取设备信息
     * @param deviceId
     * @return
     */
    Device getDeviceByDeviceId(int deviceId);
    /**
     * 验证设备是否被绑定
     * @param userId
     * @return
     */
    boolean validateBindDeviceByUserId(int userId);

    /**
     * 验证设备是否被绑定
     * @param deviceId
     * @return
     */
    boolean validateBindDeviceByDeviceId(int deviceId);

    /**
     * 验证设备是否属于用户
     * @param userId
     * @param deviceId
     * @return
     */
    boolean validateBindDeviceToUser(int userId, int deviceId);

    /**
     * 验证设备是否绑定到用户角色下
     * @param userId
     * @param deviceId
     * @param groupId
     * @return
     */
    boolean validateBindDeviceToUserRole(int userId, int deviceId, int groupId);

    /**
     * 绑定设备到用户角色下
     * @param userId
     * @param deviceId
     * @param groupId
     * @return
     */
    int bindDeviceToUserRole(int userId, int deviceId, int groupId);
    
    int bindDeviceToUserRole(int userId, int deviceId);

    /**
     * 解绑用户角色下的设备
     * @param userId
     * @param deviceId
     * @param groupId
     * @return
     */
    int unbindDeviceToUserRole(int userId, int deviceId, int groupId);

    /**
     * 根据userid获取用户设备
     * @param userId
     * @return
     */
    List<Device> getDeviceByUserId(int userId);

    /**
     * 获取最新的设备定位
     * @param deviceId
     * @return
     */
    DevicePosition getLastedDevicePositionByDeviceId(int deviceId);

    /**
     * 获取设备历史定位信息
     * @param deviceId
     * @param userId
     * @param selectCount 获取条数
     * @param startTime
     * @param endTime
     * @return
     */
    List<DevicePosition> getHistoryLocation(int deviceId, int userId, int selectCount, String startTime, String endTime) throws Exception;

    /**
     * 查询所有设备实时信息
     * @return
     */
    List<Map<String, Object>> selectDeviceDataByUserId(int userId);

    /**
     * 查询时间段内的设备健康数据
     * @param userId
     * @param deviceSerialNumber
     * @param startTime
     * @return
     */
    List<Health> selectUserDeviceData(int userId, String deviceSerialNumber, Date startTime) throws Exception;

    /**
     * 查询用户绑定的设备关系
     * @param userId
     * @return
     */
    public List<UserGroup>  selectByUserId(int userId);

    /**
     * 查询设备绑定的设备关系
     * @param deviceId
     * @return
     */
    public List<UserGroup>  selectByDeviceId(int deviceId);

    DevicePosition addDevicePosition(DevicePosition devicePosition);
	Device addDevice(Device device);

}
