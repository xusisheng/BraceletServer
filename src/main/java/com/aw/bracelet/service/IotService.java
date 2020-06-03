package com.aw.bracelet.service;

import com.aw.bracelet.huawei.entity.RegBindDevice;
import com.aw.bracelet.huawei.entity.RegDeviceAdded;
import com.aw.bracelet.huawei.entity.RegDeviceDataChanged;
import com.aw.bracelet.huawei.entity.RegDeviceInfoChanged;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IotService {

    /**
     * 添加新设备
     *
     * @param data
     * @return
     */
    Boolean deviceAdded(RegDeviceAdded data);

    /**
     * 设备绑定
     *
     * @param data
     * @return
     */
    Boolean bindDevice(RegBindDevice data);

    /**
     * 设备信息变化
     *
     * @param data
     * @return
     */
    Boolean deviceInfoChanged(RegDeviceInfoChanged data);

    /**
     * 设备数据变化
     *
     * @param data
     * @return
     */
    Boolean deviceDataChanged(RegDeviceDataChanged data);

    /**
     * 下行命令到设备，即向设备推送信息
     */
    void deviceCommonds(String deviceId, String serviceId, String method, ObjectNode paras);

    void CreateDeviceCommandDemo() throws Exception;
}
