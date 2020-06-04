package com.aw.bracelet.service;

import com.aw.bracelet.model.Device;
import com.aw.bracelet.model.DevicePosition;
import com.aw.bracelet.model.UserDevice;

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
     * 依据idcode设备ID查询设备信息
     *
     * @param idcode
     * @return
     */
    Device getDeviceByIdcode(String idcode);

    /**
     * 已经设备RFID编号查询设备信息
     *
     * @param rfid
     * @return
     */
    Device getDeviceBySn(String rfid);

    /**
     * 依据用户和设备序列号列表查询设备状态
     *
     * @param userId
     * @param sns
     * @return
     */
    List<Device> selectBySnSet(Long userId, String[] sns);

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
