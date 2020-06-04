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

    /**
     2020-06-03 14:16:11.873 [main                     ] INFO  [com.aw.bracelet.BraceletApplication               ] - Started BraceletApplication in 7.429 seconds (JVM running for 8.221)
     2020-06-03 14:16:59.500 [http-nio-80-exec-2       ] INFO  [o.a.c.core.ContainerBase.[Tomcat].[localhost].[/] ] - Initializing Spring DispatcherServlet 'dispatcherServlet'
     2020-06-03 14:16:59.561 [http-nio-80-exec-2       ] INFO  [com.aw.bracelet.controller.IotController          ] - 设备信息变化: {"notifyType":"deviceInfoChanged","deviceId":"762634d2-be6e-42d4-bc26-c3a751adcee7","gatewayId":"762634d2-be6e-42d4-bc26-c3a751adcee7","networkStatus":null,"deviceInfo":{"nodeId":null,"name":"xuss","description":null,"manufacturerId":"eefbbff1f59f4fc18fdfa67d650d3d56","manufacturerName":"STAR-IoT","mac":null,"location":"Shenzhen","deviceType":"Motion","model":"NBWatch_OTA","swVersion":null,"fwVersion":null,"hwVersion":null,"protocolType":"CoAP","bridgeId":null,"status":null,"statusDetail":null,"mute":"FALSE","supportedSecurity":null,"isSecurity":null,"signalStrength":null,"sigVersion":null,"serialNumber":null,"batteryLevel":null,"isHD":null}}
     2020-06-03 14:17:00.042 [http-nio-80-exec-1       ] WARN  [com.aw.bracelet.service.impl.DeviceServiceImpl    ] - Iot Device ID[762634d2-be6e-42d4-bc26-c3a751adcee7] not exists!!
     2020-06-03 14:17:00.042 [http-nio-80-exec-1       ] INFO  [com.aw.bracelet.service.impl.IotServiceImpl       ] - 设备：762634d2-be6e-42d4-bc26-c3a751adcee7 不存在，新增该设备
     2020-06-03 14:17:00.049 [http-nio-80-exec-2       ] WARN  [com.aw.bracelet.service.impl.DeviceServiceImpl    ] - Iot Device ID[762634d2-be6e-42d4-bc26-c3a751adcee7] not exists!!
     2020-06-03 14:17:00.050 [http-nio-80-exec-2       ] INFO  [com.aw.bracelet.service.impl.IotServiceImpl       ] - 设备信息变更时设备：762634d2-be6e-42d4-bc26-c3a751adcee7 不存在！
     2020-06-03 14:17:00.199 [http-nio-80-exec-1       ] INFO  [com.aw.bracelet.service.impl.IotServiceImpl       ] - 添加设备时绑定用户成功
     2020-06-03 14:17:00.200 [http-nio-80-exec-1       ] INFO  [com.aw.bracelet.controller.IotController          ] - 添加新设备: {"notifyType":"deviceAdded","deviceId":"762634d2-be6e-42d4-bc26-c3a751adcee7","gatewayId":"762634d2-be6e-42d4-bc26-c3a751adcee7","nodeType":"GATEWAY","deviceInfo":{"nodeId":"862177041314827","name":null,"description":null,"manufacturerId":null,"manufacturerName":null,"mac":null,"location":null,"deviceType":null,"model":null,"swVersion":null,"fwVersion":null,"hwVersion":null,"protocolType":null,"bridgeId":null,"status":"OFFLINE","statusDetail":"NOT_ACTIVE","mute":null,"supportedSecurity":null,"isSecurity":null,"signalStrength":null,"sigVersion":null,"serialNumber":null,"batteryLevel":null,"isHD":null}}
     2020-06-03 14:17:02.093 [http-nio-80-exec-3       ] INFO  [com.aw.bracelet.controller.IotController          ] - 设备数据变化: {"notifyType":"deviceDataChanged","deviceId":"c2dc6ecc-495f-48ff-95b1-177855ce5c69","gatewayId":"c2dc6ecc-495f-48ff-95b1-177855ce5c69","requestId":null,"service":{"serviceId":"NBWatch","serviceType":"NBWatch","data":{"MessageType":"UPLOAD","DeviceID":"862177041313043","Location":"E114.330887 N22.6829707","HeartRate":"074","Elevation":"+00170","Atmosphere":"994.26","Battery":"100","DeviceTime":"2020-06-03 14:16:56","IMEI":"460113004307315","Temperature":"+022.0","Steps":"000000"},"eventTime":"20200603T061701Z"}}
     2020-06-03 14:17:02.582 [http-nio-80-exec-4       ] INFO  [com.aw.bracelet.controller.IotController          ] - 设备信息变化: {"notifyType":"deviceInfoChanged","deviceId":"762634d2-be6e-42d4-bc26-c3a751adcee7","gatewayId":"762634d2-be6e-42d4-bc26-c3a751adcee7","networkStatus":null,"deviceInfo":{"nodeId":"862177041314827","name":"xuss","description":null,"manufacturerId":"eefbbff1f59f4fc18fdfa67d650d3d56","manufacturerName":"STAR-IoT","mac":null,"location":"Shenzhen","deviceType":"Motion","model":"NBWatch_OTA","swVersion":null,"fwVersion":null,"hwVersion":null,"protocolType":"CoAP","bridgeId":null,"status":null,"statusDetail":null,"mute":"FALSE","supportedSecurity":null,"isSecurity":null,"signalStrength":null,"sigVersion":null,"serialNumber":null,"batteryLevel":null,"isHD":null}}
     2020-06-03 14:17:02.593 [http-nio-80-exec-4       ] WARN  [com.aw.bracelet.service.impl.IotServiceImpl       ] - 设备状态不合法！
     2020-06-03 14:17:02.669 [http-nio-80-exec-5       ] INFO  [com.aw.bracelet.controller.IotController          ] - 绑定设备: {"notifyType":"bindDevice","deviceId":"762634d2-be6e-42d4-bc26-c3a751adcee7","resultCode":"succeeded","deviceInfo":{"nodeId":"862177041314827","name":"xuss","description":null,"manufacturerId":"eefbbff1f59f4fc18fdfa67d650d3d56","manufacturerName":"STAR-IoT","mac":null,"location":"Shenzhen","deviceType":"Motion","model":"NBWatch_OTA","swVersion":null,"fwVersion":null,"hwVersion":null,"protocolType":"CoAP","bridgeId":null,"status":"ONLINE","statusDetail":"NONE","mute":"FALSE","supportedSecurity":null,"isSecurity":null,"signalStrength":null,"sigVersion":null,"serialNumber":null,"batteryLevel":null,"isHD":null}}
     2020-06-03 14:17:02.671 [http-nio-80-exec-6       ] INFO  [com.aw.bracelet.controller.IotController          ] - 设备信息变化: {"notifyType":"deviceInfoChanged","deviceId":"762634d2-be6e-42d4-bc26-c3a751adcee7","gatewayId":"762634d2-be6e-42d4-bc26-c3a751adcee7","networkStatus":null,"deviceInfo":{"nodeId":null,"name":null,"description":null,"manufacturerId":null,"manufacturerName":null,"mac":null,"location":null,"deviceType":null,"model":null,"swVersion":null,"fwVersion":null,"hwVersion":null,"protocolType":null,"bridgeId":null,"status":"ONLINE","statusDetail":"NONE","mute":null,"supportedSecurity":null,"isSecurity":null,"signalStrength":null,"sigVersion":null,"serialNumber":null,"batteryLevel":null,"isHD":null}}
     */

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
//        req_str = "{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"98525533-0588-4000-b2c2-11d800a2d328\",\"gatewayId\":\"98525533-0588-4000-b2c2-11d800a2d328\",\"requestId\":null,\"service\":{\"serviceId\":\"NBWatch\",\"serviceType\":\"NBWatch\",\"data\":{\"MessageType\":\"DEVSOS\",\"DeviceID\":\"862177041313472\",\"Location\":\"E110.308205 N025.262453\",\"HeartRate\":\"000\",\"Elevation\":\"+27990\",\"Atmosphere\":\"982.15\",\"Battery\":\"100\",\"DeviceTime\":\"2020-05-27 16:54:34\",\"IMEI\":\"460113004305950\",\"Temperature\":\"+270.0\",\"Steps\":\"000000\"},\"eventTime\":\"20200527T085437Z\"}}";
        req_str = "{\"notifyType\":\"deviceDataChanged\",\"deviceId\":\"4955fab4-11e1-440a-822b-15a229013d16\",\"gatewayId\":\"4955fab4-11e1-440a-822b-15a229013d16\",\"requestId\":null,\"service\":{\"serviceId\":\"NBWatch\",\"serviceType\":\"NBWatch\",\"data\":{\"MessageType\":\"UPLOAD\",\"DeviceID\":\"862177041313308\",\"Location\":\"E110.308235 N025.262451\",\"HeartRate\":\"000\",\"Elevation\":\"+00314\",\"Atmosphere\":\"978.34\",\"Battery\":\"060\",\"DeviceTime\":\"2020-06-04 14:39:36\",\"IMEI\":\"460113004304696\",\"Temperature\":\"+41.20\",\"Steps\":\"000017\"},\"eventTime\":\"20200604T063939Z\"}}";
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
    public void createDeviceCommandDemo() throws Exception {
        iotService.CreateDeviceCommandDemo();
    }
}