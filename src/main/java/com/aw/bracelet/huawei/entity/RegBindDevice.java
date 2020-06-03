package com.aw.bracelet.huawei.entity;

import lombok.Data;

@Data
public class RegBindDevice extends RegIot {
    private String resultCode;
    private DeviceInfo deviceInfo;
}
