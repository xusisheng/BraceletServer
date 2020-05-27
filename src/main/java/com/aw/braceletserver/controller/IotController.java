package com.aw.braceletserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.constants.Constant;
import com.aw.braceletserver.service.TxManagerService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
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
    private TxManagerService txManagerService;

    @PostMapping("/device/bind")
    @ResponseBody
    public ResponseEntity<HttpStatus> bindDevice(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "绑定设备";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/device/added")
    @ResponseBody
    public ResponseEntity<HttpStatus> deviceAdded(HttpServletRequest request, HttpServletResponse response) {
        String strNotify = "添加新设备";
        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
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
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
            is.close();
            logger.info("{}: {}", strNotify, req_str);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.warn("{}: {}", strNotify, e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
