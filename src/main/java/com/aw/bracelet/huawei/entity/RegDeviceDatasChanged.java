package com.aw.bracelet.huawei.entity;

import lombok.Data;

import java.util.List;

@Data
public class RegDeviceDatasChanged extends RegIot {
    private String requestId;
    private List<DeviceServiceData> services;
}
