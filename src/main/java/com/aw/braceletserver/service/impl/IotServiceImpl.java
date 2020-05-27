package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.huawei.utils.Constant;
import com.aw.braceletserver.huawei.utils.HttpsUtil;
import com.aw.braceletserver.service.IotService;
import com.aw.braceletserver.service.IotTokenService;
import com.aw.braceletserver.utils.JsonMapper;
import com.aw.braceletserver.utils.JsonUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IotServiceImpl implements IotService {
    private Logger logger = LoggerFactory.getLogger(IotServiceImpl.class);

    @Override
    public void CreateDeviceCommand() throws Exception {
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
