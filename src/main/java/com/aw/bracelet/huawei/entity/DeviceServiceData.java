package com.aw.bracelet.huawei.entity;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

@Data
public class DeviceServiceData {
    private String serviceId;
    private String serviceType;
    private ObjectNode data;
    private String eventTime;
}
