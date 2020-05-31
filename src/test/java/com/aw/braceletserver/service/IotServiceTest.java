package com.aw.braceletserver.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.BraceletServerApplication;
import com.aw.braceletserver.constants.Constants;
import com.aw.braceletserver.entity.Coordinate;
import com.aw.braceletserver.huawei.entity.RegDeviceAdded;
import com.aw.braceletserver.huawei.entity.RegDeviceDataChanged;
import com.aw.braceletserver.utils.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BraceletServerApplication.class)
public class IotServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(IotServiceTest.class);
    private String req_str = "";

    @Autowired
    private IotService iotService;

    @Test
    public void deviceAdded() {
        req_str = "{\"notifyType\":\"deviceAdded\",\"deviceId\":\"f1dd19bb-79d5-4be6-9f59-586e2e8fc1b3\",\"gatewayId\":\"f1dd19bb-79d5-4be6-9f59-586e2e8fc1b3\",\"nodeType\":\"GATEWAY\",\"deviceInfo\":{\"nodeId\":\"DA:9B:4F:F1:D0:83\",\"name\":null,\"description\":null,\"manufacturerId\":null,\"manufacturerName\":null,\"mac\":null,\"location\":null,\"deviceType\":null,\"model\":null,\"swVersion\":null,\"fwVersion\":null,\"hwVersion\":null,\"protocolType\":null,\"bridgeId\":null,\"status\":\"OFFLINE\",\"statusDetail\":\"NOT_ACTIVE\",\"mute\":null,\"supportedSecurity\":null,\"isSecurity\":null,\"signalStrength\":null,\"sigVersion\":null,\"serialNumber\":null,\"batteryLevel\":null,\"isHD\":null}}";
        RegDeviceAdded data = JsonMapper.toObject(req_str, RegDeviceAdded.class);
        iotService.deviceAdded(data);
        System.out.println("OK");
    }

    @Test
    public void deviceDataChanged() {
        req_str = "{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"98525533-0588-4000-b2c2-11d800a2d328\",\"gatewayId\":\"98525533-0588-4000-b2c2-11d800a2d328\",\"requestId\":null,\"service\":{\"serviceId\":\"NBWatch\",\"serviceType\":\"NBWatch\",\"data\":{\"MessageType\":\"DEVSOS\",\"DeviceID\":\"862177041313472\",\"Location\":\"E110.308205 N025.262453\",\"HeartRate\":\"000\",\"Elevation\":\"+27990\",\"Atmosphere\":\"982.15\",\"Battery\":\"100\",\"DeviceTime\":\"2020-05-27 16:54:34\",\"IMEI\":\"460113004305950\",\"Temperature\":\"+270.0\",\"Steps\":\"000000\"},\"eventTime\":\"20200527T085437Z\"}}";
//        RegDeviceDataChanged data = JsonMapper.toObject(req_str, RegDeviceDataChanged.class);
//        ObjectNode on = data.getService().getData();
//        String gps = on.get("Location").textValue();
//        Coordinate coordinate = new Coordinate(gps);
//        String sss = on.get("Atmosphere").textValue();
//        String www = on.get("Atmosphere").asText();
//        Integer ii = on.get("Battery").asInt();
//        Integer jj = on.get("Battery").intValue();  // wrong
//        System.out.println(on.get("MessageType").asText());
//        iotService.deviceDataChanged(data);
//        StateEnum e1 = EnumHelperUtil.indexOf(StateEnum.class, 0);
//        StateEnum e2 = EnumHelperUtil.nameOf(StateEnum.class, "USER_NOT_EXIST");
//        StateEnum e3 = EnumHelperUtil.getByStringTypeCode(StateEnum.class, "getDesc", "用户不存在");
//        Constants.DeviceStatus e11 = EnumHelperUtil.indexOf(Constants.DeviceStatus.class, 0);
//        Constants.DeviceStatus e12 = EnumHelperUtil.nameOf(Constants.DeviceStatus.class, "ONLINE");
//        Constants.DeviceStatus e13 = EnumHelperUtil.getByStringTypeCode(Constants.DeviceStatus.class, "getValue", "OFFLINE");
        String method = Constants.METHOD.SEND_NOTICE.name();
        System.out.println(method);
        System.out.println("OK");
    }

    @Test
    public void deviceCommonds() {
    }

    @Test
    public void createDeviceCommandDemo() {
    }
}