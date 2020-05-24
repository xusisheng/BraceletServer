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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 电信IoT平台接口
 */
@RestController
@RequestMapping("")
public class IotController {
    private static final Logger logger = LoggerFactory.getLogger(IotController.class);

    @Autowired
    private TxManagerService txManagerService;

    /**
     * 数据上送
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadData", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> uploadData(HttpServletRequest request, HttpServletResponse response) {

        String log = "数据上送";

        try {
            InputStream is = request.getInputStream();
            String req_str = IOUtils.toString(is, Constant.CHARSET.UTF8);
            is.close();
            logger.info("{}请求数据：{}", log, req_str);
            if (StringUtils.isBlank(req_str)) {
                logger.warn("{}请求数据为空", log);
            }

            JSONObject jo = JSON.parseObject(req_str);
            boolean result = txManagerService.uploadDeviceData(jo);
            logger.info("数据上报后台处理结果：{}", result);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * 通知指令给设备
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/notifyDevice", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> notifyDevice(HttpServletRequest request, HttpServletResponse response) {
        //TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 设备事件上报
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/deviceEvent", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> deviceEvent(HttpServletRequest request, HttpServletResponse response) {
        //TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 设备信息变化
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/deviceInfoChange", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> deviceInfoChange(HttpServletRequest request, HttpServletResponse response) {
        //TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 设备服务信息变更
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/deviceServiceChange", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> deviceInfochange(HttpServletRequest request, HttpServletResponse response) {
        //TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 消息命令确认
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/notifyConfirm", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> notifyConfirm(HttpServletRequest request, HttpServletResponse response) {
        //TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
