package com.aw.bracelet.service;

import com.aw.bracelet.BraceletApplication;
import com.aw.bracelet.constants.Constants;
import com.aw.bracelet.huawei.entity.RegDeviceAdded;
import com.aw.bracelet.huawei.entity.RegDeviceDataChanged;
import com.aw.bracelet.huawei.entity.RegDeviceInfoChanged;
import com.aw.bracelet.model.Device;
import com.aw.bracelet.utils.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BraceletApplication.class)
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
    public void deviceInfoChanged() {
        req_str = "{\"notifyType\":\"deviceInfoChanged\",\"deviceId\":\"fca3cd5f-c303-461e-b55b-2b218fe735fa\",\"gatewayId\":\"fca3cd5f-c303-461e-b55b-2b218fe735fa\",\"networkStatus\":null,\"deviceInfo\":{\"nodeId\":null,\"name\":\"xuss\",\"description\":null,\"manufacturerId\":\"eefbbff1f59f4fc18fdfa67d650d3d56\",\"manufacturerName\":\"STAR-IoT\",\"mac\":null,\"location\":\"Shenzhen\",\"deviceType\":\"Motion\",\"model\":\"NBWatch_OTA\",\"swVersion\":null,\"fwVersion\":null,\"hwVersion\":null,\"protocolType\":\"CoAP\",\"bridgeId\":null,\"status\":null,\"statusDetail\":null,\"mute\":\"FALSE\",\"supportedSecurity\":null,\"isSecurity\":null,\"signalStrength\":null,\"sigVersion\":null,\"serialNumber\":null,\"batteryLevel\":null,\"isHD\":null}}";
        RegDeviceInfoChanged data = JsonMapper.toObject(req_str, RegDeviceInfoChanged.class);
        iotService.deviceInfoChanged(data);
        System.out.println("OK");
    }

    @Test
    public void deviceDataChanged() {
        req_str = "{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"98525533-0588-4000-b2c2-11d800a2d328\",\"gatewayId\":\"98525533-0588-4000-b2c2-11d800a2d328\",\"requestId\":null,\"service\":{\"serviceId\":\"NBWatch\",\"serviceType\":\"NBWatch\",\"data\":{\"MessageType\":\"DEVSOS\",\"DeviceID\":\"862177041313472\",\"Location\":\"E110.308205 N025.262453\",\"HeartRate\":\"000\",\"Elevation\":\"+27990\",\"Atmosphere\":\"982.15\",\"Battery\":\"100\",\"DeviceTime\":\"2020-05-27 16:54:34\",\"IMEI\":\"460113004305950\",\"Temperature\":\"+270.0\",\"Steps\":\"000000\"},\"eventTime\":\"20200527T085437Z\"}}";
        req_str = "{\"notifyType\":\"deviceDataChanged\",\"requestId\":\"6c3c60f0-f1cb-d23f-bbf7-46152a726aea_9362\",\"deviceId\":\"01006f25-ab60-4a7e-8b0a-6dcfa15e43cc\",\"gatewayId\":\"0010256458\",\"service\":{\"serviceType\":\"Brightness\",\"data\":{\"brightness\":80},\"eventTime\":\"20170311T163657Z\",\"serviceId\":\"Brightness\"}}";
        RegDeviceDataChanged data = JsonMapper.toObject(req_str, RegDeviceDataChanged.class);
        ObjectNode on = data.getService().getData();
//        String gps = on.get("Location").textValue();
//        Coordinate coordinate = new Coordinate(gps);
        String sss = on.get("DeviceID").textValue();
        String www = on.get("DeviceID").asText();
        Integer ii = on.get("Battery").asInt();
        Integer jj = on.get("Battery").intValue();  // wrong
//        System.out.println(on.get("MessageType").asText());
        Device device = new Device();
        device.setIdcode(on.get("DeviceID").asText());
        iotService.deviceDataChanged(data);
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