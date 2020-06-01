package com.aw.bracelet.huawei.entity;

import lombok.Data;

@Data
public class RegDeviceAdded extends RegIot {
    private String nodeType;
    private DeviceInfo deviceInfo;
}
