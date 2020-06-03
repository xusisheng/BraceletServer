package com.aw.bracelet.service.impl;

import com.aw.bracelet.constants.Constants;
import com.aw.bracelet.entity.Coordinate;
import com.aw.bracelet.huawei.entity.*;
import com.aw.bracelet.huawei.utils.Constant;
import com.aw.bracelet.huawei.utils.HttpsUtil;
import com.aw.bracelet.model.Device;
import com.aw.bracelet.model.DevicePosition;
import com.aw.bracelet.model.UserDevice;
import com.aw.bracelet.service.*;
import com.aw.bracelet.utils.DateUtil;
import com.aw.bracelet.utils.EnumHelperUtil;
import com.aw.bracelet.utils.JsonUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aw.bracelet.constants.Constants.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class IotServiceImpl implements IotService {
    private static final Logger logger = LoggerFactory.getLogger(IotServiceImpl.class);
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserDeviceService userDeviceService;
    @Autowired
    private DevicePositionService devicePositionService;

    private DeviceStatus getDeviceStatus(String status) {
        try {
            return EnumHelperUtil.getByStringTypeCode(Constants.DeviceStatus.class, "getValue", status);
        } catch (Exception e) {
            logger.warn("设备状态不合法！");
        }
        return DeviceStatus.OFFLINE;
    }

    @Override
    public Boolean deviceAdded(RegDeviceAdded data) {
        //检查通知类型
        if (!data.getNotifyType().equalsIgnoreCase("deviceAdded")) {
            logger.warn("添加设备时通知类型错误!!!");
            return true;
        }
        String iotDeviceId = data.getDeviceId();
        String nodeType = data.getNodeType();
        if (StringUtils.isBlank(iotDeviceId) || StringUtils.isBlank(nodeType)) {
            logger.warn("添加设备时设备ID和设备类型不能为空!!!");
            return true;
        }
        DeviceInfo deviceInfo = data.getDeviceInfo();
        Device device = deviceService.getDeviceByIotid(iotDeviceId);
        if (device != null) {
            logger.info("设备：{} 已存在。", iotDeviceId);
            return true;
        }
        //新增加设备
        logger.info("设备：{} 不存在，新增该设备", iotDeviceId);
        device = new Device();
        try {
            BeanUtils.copyProperties(device, deviceInfo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        device.setIotDeviceid(iotDeviceId);
        device.setIdcode(deviceInfo.getNodeId());
        device.setSn(deviceInfo.getNodeId());
        device.setStatus(getDeviceStatus(deviceInfo.getStatus()).getCode());
        device.setCreateTime(new Date());
        deviceService.insert(device);

        //绑定设备到用户（插入用户设备关系表）
        UserDevice userDevice = new UserDevice();
        userDevice.setUserId(Constants.USERID);
        userDevice.setDeviceId(device.getId());
        userDevice.setStatus(Constants.USERDEVICESTATUS.BIND);
        userDevice.setCreateTime(new Date());
        if (userDeviceService.insert(userDevice) > 0) {
            logger.info("添加设备时绑定用户成功");
        } else {
            logger.info("添加设备时绑定用户失败");
        }
        return true;
    }

    @Override
    public Boolean bindDevice(RegBindDevice data) {
        //检查通知类型
        if (!data.getNotifyType().equalsIgnoreCase("bindDevice")) {
            logger.warn("设备绑定时通知类型错误!!!");
            return true;
        }
        if (!data.getResultCode().equalsIgnoreCase("succeeded")) {
            logger.warn("设备绑定失败！");
            return true;
        }
        String iotDeviceId = data.getDeviceId();
        DeviceInfo deviceInfo = data.getDeviceInfo();
        Device device = deviceService.getDeviceByIotid(iotDeviceId);
        for (int i = 0; i < 3; i++) {
            if (device == null) {
                try {
                    logger.info("sleep 500");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                device = deviceService.getDeviceByIotid(iotDeviceId);
                continue;
            }
            logger.info("设备绑定时设备：{} 不存在！", iotDeviceId);
            return true;
        }

        //更新设备信息
        try {
            BeanUtils.copyProperties(device, deviceInfo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        device.setIdcode(deviceInfo.getNodeId());
        device.setSn(deviceInfo.getNodeId());
        device.setStatus(getDeviceStatus(deviceInfo.getStatus()).getCode());
        deviceService.updateByPrimaryKeySelective(device);
        return null;
    }

    @Override
    public Boolean deviceInfoChanged(RegDeviceInfoChanged data) {
        //检查通知类型
        if (!data.getNotifyType().equalsIgnoreCase("deviceInfoChanged")) {
            logger.warn("设备信息变更时通知类型错误!!!");
            return true;
        }
        String iotDeviceId = data.getDeviceId();
        DeviceInfo deviceInfo = data.getDeviceInfo();
        Device device = deviceService.getDeviceByIotid(iotDeviceId);
        for (int i = 0; i < 3; i++) {
            logger.info("i: {}", i);
            if (device != null) {
                break;
            }
            try {
                logger.info("sleep 500");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            device = deviceService.getDeviceByIotid(iotDeviceId);
        }
        if (device == null) {
            logger.info("设备信息变更时设备：{} 不存在，忽略该数据", iotDeviceId);
            return true;
        }

        //更新设备信息
        try {
            BeanUtils.copyProperties(device, deviceInfo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        device.setIdcode(deviceInfo.getNodeId());
        device.setSn(deviceInfo.getNodeId());
        device.setStatus(getDeviceStatus(deviceInfo.getStatus()).getCode());
        deviceService.updateByPrimaryKeySelective(device);
        return true;
    }

    @Override
    public Boolean deviceDataChanged(RegDeviceDataChanged data) {
        //检查通知类型
        if (!data.getNotifyType().equalsIgnoreCase("deviceDataChanged")) {
            logger.warn("设备数据变化时通知类型错误!!!");
            return true;
        }
        //检查设备
        String iotDeviceId = data.getDeviceId();
        Device device = deviceService.getDeviceByIotid(iotDeviceId);
        ObjectNode on = data.getService().getData();
        if (device == null) {
            logger.info("设备数据变化时设备：{} 不存在，忽略该数据", iotDeviceId);
            return true;
        }
        DevicePosition devicePosition = new DevicePosition();
        devicePosition.setDeviceId(device.getId());
        devicePosition.setIdcode(on.get("DeviceID").asText());
        devicePosition.setUserId(Constants.USERID);
        //UTC时间，减8小时才是东八区时间
        Date upTime = DateUtils.addHours(DateUtil.getDateFromString(on.get("DeviceTime").asText()), -8);
        devicePosition.setUptime(upTime);
        devicePosition.setMessageType(on.get("MessageType").asText());
        Coordinate coordinate = new Coordinate(on.get("Location").asText());
        devicePosition.setLongitude(coordinate.getLongitude());
        devicePosition.setLatitude(coordinate.getLatitude());
        devicePosition.setAltitude(new BigDecimal(on.get("Elevation").asText()));
        devicePosition.setAtmosphere(new BigDecimal(on.get("Atmosphere").asText()));
        devicePosition.setBattery(on.get("Battery").asInt());
        devicePosition.setHeartBeat(on.get("HeartRate").asInt());
        devicePosition.setTemperature(on.get("Temperature").asDouble());
        devicePosition.setSteps(on.get("Steps").asInt());
        devicePosition.setOnlineStatus(true);
        devicePosition.setCreateTime(new Date());
        devicePositionService.insert(devicePosition);
        return true;
    }

    @Override
    public void deviceCommonds(String deviceId, String serviceId, String method, ObjectNode paras) {
        HttpsUtil httpsUtil = new HttpsUtil();
        try {
            httpsUtil.initSSLConfigForTwoWay();
        } catch (Exception e) {
            e.printStackTrace();
        }
//      ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"length\": 13, \"content\": \"SOS Confirmed\"}");
        Map<String, Object> paramCommand = new HashMap<>();
        paramCommand.put("serviceId", StringUtils.isBlank(serviceId) ? Constants.SERVICEID : serviceId);
        paramCommand.put("method", StringUtils.isBlank(method) ? Constants.METHOD.SEND_NOTICE.name() : method);
        paramCommand.put("paras", paras);

        Map<String, Object> paramCreateDeviceCommand = new HashMap<>();
        paramCreateDeviceCommand.put("deviceId", deviceId);
        paramCreateDeviceCommand.put("command", paramCommand);
        paramCreateDeviceCommand.put("callbackUrl", "");
        paramCreateDeviceCommand.put("maxRetransmit", 3);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, Constant.APPID);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + IotTokenService.getToken().getAccessToken());
        String jsonRequest = JsonUtil.jsonObj2Sting(paramCreateDeviceCommand);
        HttpResponse responseCreateDeviceCommand = httpsUtil.doPostJson(Constant.CREATE_DEVICE_CMD, header, jsonRequest);

        try {
            String responseBody = httpsUtil.getHttpResponseBody(responseCreateDeviceCommand);
            System.out.println("CreateDeviceCommand, response content:");
            System.out.println(responseCreateDeviceCommand.getStatusLine());
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void CreateDeviceCommandDemo() throws Exception {
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();
        String accessToken = IotTokenService.getToken().getAccessToken();
        String urlCreateDeviceCommand = Constant.CREATE_DEVICE_CMD;
        String appId = Constant.APPID;

        //please replace the deviceId, when you use the demo.
        String deviceId = "98525533-0588-4000-b2c2-11d800a2d328";
        String callbackUrl = "";//Constant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL;
        Integer maxRetransmit = 3;

        //please replace the following parameter values, when you use the demo.
        //And those parameter values must be consistent with the content of profile that have been preset to IoT platform.
        //The following parameter values of this demo are use the watermeter profile that already initialized to IoT platform.
        String serviceId = "NBWatch";
        String method = "SEND_NOTICE";
        ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"length\": 13, \"content\": \"SOS Confirmed\"}");

        Map<String, Object> paramCommand = new HashMap<>();
        paramCommand.put("serviceId", serviceId);
        paramCommand.put("method", method);
        paramCommand.put("paras", paras);

        Map<String, Object> paramCreateDeviceCommand = new HashMap<>();
        paramCreateDeviceCommand.put("deviceId", deviceId);
        paramCreateDeviceCommand.put("command", paramCommand);
        paramCreateDeviceCommand.put("callbackUrl", callbackUrl);
        paramCreateDeviceCommand.put("maxRetransmit", maxRetransmit);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        System.out.println("appId: " + appId);
        System.out.println("accessToken: " + accessToken);
        System.out.println("url: " + urlCreateDeviceCommand);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramCreateDeviceCommand);
        HttpResponse responseCreateDeviceCommand = httpsUtil.doPostJson(urlCreateDeviceCommand, header, jsonRequest);

        String responseBody = httpsUtil.getHttpResponseBody(responseCreateDeviceCommand);

        System.out.println("CreateDeviceCommand, response content:");
        System.out.println(responseCreateDeviceCommand.getStatusLine());
        System.out.println(responseBody);
        System.out.println();
    }
}
