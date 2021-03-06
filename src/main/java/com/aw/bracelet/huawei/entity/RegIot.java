package com.aw.bracelet.huawei.entity;

import com.aw.bracelet.entity.BaseEntity;
import lombok.Data;

@Data
public class RegIot extends BaseEntity {
    private String notifyType;
    private String deviceId; //IoT平台设备ID，UUID格式
    private String requestId;
    private String gatewayId; //网关ID，与设备ID一致
}
