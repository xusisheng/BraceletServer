package com.aw.bracelet.huawei.entity;

import lombok.Data;

@Data
public class DeviceInfo {
    private String nodeId;      //设备唯一标识码，通常使用MAC地址，Serial No或IMEI作为nodeId。
    private String name;
    private String description;
    private String manufacturerId;
    private String manufacturerName;
    private String mac;
    private String location;
    private String deviceType;      //设备类型，大驼峰命名方式，如MultiSensor、ContactSensor、CameraGateway。
    private String model;           //Z-Wave：productType + productId，16进制格式XXXX-XXXX补0对齐，如：001A-0A12，其他协议的格式待定
    private String swVersion;
    private String fwVersion;
    private String hwVersion;
    private String protocolType;    //协议类型：CoAP，huaweiM2M，Z-Wave，ONVIF，WPS，Hue，WiFi，J808，Gateway，ZigBee，LWM2M
    private String bridgeId;
    private String status;  //设备的状态，表示设备是否在线，取值范围：ONLINE、OFFLINE、ABNORMAL。若设备超过25（默认值）小时未向平台上报数据或发送消息，则设备状态为ABNORMAL（默认值）；若设备超过49小时未向平台上报数据或发送消息，则设备状态为OFFLINE。
    //设备的状态详情，跟status取值对应。
    // status为ONLINE时，取值NONE COMMUNICATION_ERROR，CONFIGURATION_ERROR BRIDGE_OFFLINE或FIRMWARE_UPDATING DUTY_CYCLE NOT_ACTIVE
    // status为OFFLINE时，取值NONE CONFIGURATION_PENDING
    private String statusDetail;
    private String mute;    //表示设备是否处于冻结状态，即设备上报数据时，平台是否会管理和保存。 TRUE：冻结状态  FALSE：非冻结状态
    private String supportedSecurity;
    private String isSecurity;
    private String signalStrength;
    private String sigVersion;
    private String serialNumber;    //设备的序列号
    private String batteryLevel;
}
