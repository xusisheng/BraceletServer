package com.aw.bracelet.controller;

import com.aw.bracelet.constants.Constants;
import com.aw.bracelet.huawei.entity.RegDeviceAdded;
import com.aw.bracelet.huawei.entity.RegDeviceDataChanged;
import com.aw.bracelet.service.IotService;
import com.aw.bracelet.utils.JsonMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 电信IoT平台接口
 */
@RestController
@RequestMapping("/iot")
public class IotController {
    private static final Logger logger = LoggerFactory.getLogger(IotController.class);

    @Autowired
    private IotService iotService;

    @PostMapping("/device/added")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceAdded(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "添加新设备";
        try {
//            设备名称 xuss
//            设备ID f1dd19bb-79d5-4be6-9f59-586e2e8fc1b3
//            PSK码 （使用DTLS协议时需要使用到该PSK码，请您牢记！） 363b4fd1d01bc364a97064bfe3e336be
            //添加新设备: {"notifyType":"deviceAdded","deviceId":"f1dd19bb-79d5-4be6-9f59-586e2e8fc1b3","gatewayId":"f1dd19bb-79d5-4be6-9f59-586e2e8fc1b3","nodeType":"GATEWAY","deviceInfo":{"nodeId":"DA:9B:4F:F1:D0:83","name":null,"description":null,"manufacturerId":null,"manufacturerName":null,"mac":null,"location":null,"deviceType":null,"model":null,"swVersion":null,"fwVersion":null,"hwVersion":null,"protocolType":null,"bridgeId":null,"status":"OFFLINE","statusDetail":"NOT_ACTIVE","mute":null,"supportedSecurity":null,"isSecurity":null,"signalStrength":null,"sigVersion":null,"serialNumber":null,"batteryLevel":null,"isHD":null}}
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            iotService.deviceAdded(JsonMapper.toObject(req_str, RegDeviceAdded.class));
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/bind")
    @ResponseBody
    public ResponseEntity<HttpStatus> bindDevice(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "绑定设备";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/info/changed")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceInfoChanged(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "设备信息变化";
        try {
            //设备信息变化: {"notifyType":"deviceInfoChanged","deviceId":"f1dd19bb-79d5-4be6-9f59-586e2e8fc1b3","gatewayId":"f1dd19bb-79d5-4be6-9f59-586e2e8fc1b3","networkStatus":null,"deviceInfo":{"nodeId":null,"name":"xuss","description":null,"manufacturerId":"eefbbff1f59f4fc18fdfa67d650d3d56","manufacturerName":"STAR-IoT","mac":null,"location":"Shenzhen","deviceType":"Motion","model":"NBWatch_OTA","swVersion":null,"fwVersion":null,"hwVersion":null,"protocolType":"CoAP","bridgeId":null,"status":null,"statusDetail":null,"mute":"FALSE","supportedSecurity":null,"isSecurity":null,"signalStrength":null,"sigVersion":null,"serialNumber":null,"batteryLevel":null,"isHD":null}}
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/data/changed")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceDataChanged(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "设备数据变化";
        try {
            //设备数据变化: {"notifyType":"deviceDataChanged","deviceId":"4955fab4-11e1-440a-822b-15a229013d16","gatewayId":"4955fab4-11e1-440a-822b-15a229013d16","requestId":null,"service":{"serviceId":"NBWatch","serviceType":"NBWatch","data":{"MessageType":"UPLOAD","DeviceID":"862177041313308","Location":"E4294967296 N0429496729","HeartRate":"071","Elevation":"+00121","Atmosphere":"999.76","Battery":"060","DeviceTime":"2020-05-27 16:36:07","IMEI":"460113004304696","Temperature":"+27.90","Steps":"001114"},"eventTime":"20200527T083613Z"}}
            //设备数据变化: {"notifyType":"deviceDataChanged","deviceId":"98525533-0588-4000-b2c2-11d800a2d328","gatewayId":"98525533-0588-4000-b2c2-11d800a2d328","requestId":null,"service":{"serviceId":"NBWatch","serviceType":"NBWatch","data":{"MessageType":"DEVSOS","DeviceID":"862177041313472","Location":"E110.308205 N025.262453","HeartRate":"000","Elevation":"+27990","Atmosphere":"982.15","Battery":"100","DeviceTime":"2020-05-27 16:54:34","IMEI":"460113004305950","Temperature":"+270.0","Steps":"000000"},"eventTime":"20200527T085437Z"}}
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            iotService.deviceDataChanged(JsonMapper.toObject(req_str, RegDeviceDataChanged.class));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/datas/changed")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceDatasChanged(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "设备数据批量变化";
        try {
            //设备数据批量变化: {"notifyType":"deviceDatasChanged","requestId":null,"deviceId":"4955fab4-11e1-440a-822b-15a229013d16","gatewayId":"4955fab4-11e1-440a-822b-15a229013d16","services":[{"serviceId":"NBWatch","serviceType":"NBWatch","data":{"MessageType":"UPLOAD","DeviceID":"862177041313308","Location":"E4294967296 N0429496729","HeartRate":"071","Elevation":"+00121","Atmosphere":"999.76","Battery":"060","DeviceTime":"2020-05-27 16:36:07","IMEI":"460113004304696","Temperature":"+27.90","Steps":"001114"},"eventTime":"20200527T083613Z"}]}
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/deleted")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceDeleted(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "删除设备";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/service/info/changed")
    @ResponseBody
    public ResponseEntity<HttpStatus> serviceInfoChanged(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "服务信息变化";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/rule/event")
    @ResponseBody
    public ResponseEntity<HttpStatus> ruleEvent(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "规则事件";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/model/added")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceModelAdded(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "添加设备模型";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/model/deleted")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceModelDeleted(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "删除设备模型";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/sw/upgrade/state/change/notify")
    @ResponseBody
    public ResponseEntity<HttpStatus> swUpgradeStateChangeNotify(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "软件升级状态变更通";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/sw/upgrade/result/notify")
    @ResponseBody
    public ResponseEntity<HttpStatus> swUpgradeResultNotify(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "软件升级结果通知";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/fw/upgrade/state/change/notify")
    @ResponseBody
    public ResponseEntity<HttpStatus> fwUpgradeStateChangeNotify(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "固件升级状态变更通";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/fw/upgrade/result/notify")
    @ResponseBody
    public ResponseEntity<HttpStatus> fwUpgradeResultNotify(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "固件升级结果通知";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constants.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
