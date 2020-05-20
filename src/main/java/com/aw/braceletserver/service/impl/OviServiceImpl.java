package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.entity.oviphone.*;
import com.aw.braceletserver.properties.ApiUri;
import com.aw.braceletserver.service.OviService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OviServiceImpl implements OviService {
    private static final Logger logger = LoggerFactory.getLogger(OviServiceImpl.class);

    @Autowired
    private ApiUri apiUri;

    @Override
    public List<PersonDeviceInfo> getDeviceList(ReqDeviceList req) {
//        try {
//            System.out.println(req.toJson());
//            HttpClientResult _result = HttpClientUtils.doPostForJson(apiUri.getEquimentInfo(), req.toJson());
//            if (_result.getCode() == 200) {
//                JSONObject objJson = JSONObject.parseObject(_result.getContent());
//                RespDeviceInfo respDeviceInfo = JSON.toJavaObject(objJson, RespDeviceInfo.class);
//                return respDeviceInfo.getItems();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public List<HistoryInfo> getHistoryLocation(ReqHistoryLocation req) {
        try {
//            HttpClientResult _result = HttpClientUtils.doPostForJson(apiUri.getHistoryTrack(), req.toJson());
//            if (_result.getCode() == 200) {
//                JSONObject objJson = JSONObject.parseObject(_result.getContent());
//                RespHistoryLocation respHistoryLocation = JSON.toJavaObject(objJson, RespHistoryLocation.class);
//                return respHistoryLocation.getItems();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RespHealth getHealth(ReqHealth req) {
        try {
//            HttpClientResult _result = HttpClientUtils.doPostForJson(apiUri.getHealthInfo(), req.toJson());
//            if (_result.getCode() == 200) {
//                JSONObject objJson = JSONObject.parseObject(_result.getContent());
//                RespHealth respHealth = JSON.toJavaObject(objJson, RespHealth.class);
//                return respHealth;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RespSendCommad sendCommand(ReqSendCommand req) {
        try {
//            HttpClientResult _result = HttpClientUtils.doPostForJson(apiUri.getSendCmd(), req.toJson());
//            if (_result.getCode() == 200) {
//                JSONObject objJson = JSONObject.parseObject(_result.getContent());
//                return null;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ExceptionInfo> getHistoryWarning(ReqHistoryWarning req) {
        try {
//            HttpClientResult _result = HttpClientUtils.doPostForJson(apiUri.getHistoryWarnmsg(), req.toJson());
//            if (_result.getCode() == 200) {
//                JSONObject objJson = JSONObject.parseObject(_result.getContent());
//                RespHistoryWarning respHistoryWarning = JSON.toJavaObject(objJson, RespHistoryWarning.class);
//                return respHistoryWarning.getItems();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
