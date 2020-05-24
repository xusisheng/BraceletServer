package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.entity.*;
import com.aw.braceletserver.entity.oviphone.PersonDeviceInfo;
import com.aw.braceletserver.entity.oviphone.ReqDeviceList;
import com.aw.braceletserver.service.ApiService;
import com.aw.braceletserver.service.OviService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Autowired
    private OviService oviService;

    @Override
    public List<BraceletTrack> getHistoryLocation(UserInfo userInfo) {
        //发送请求
        ReqDeviceList reqDeviceList = new ReqDeviceList();
        reqDeviceList.setToken(userInfo.getAccessToken());
        reqDeviceList.setUserId(userInfo.getItem().getUserId());
        reqDeviceList.setMapType("0");
        List<PersonDeviceInfo> listInfo = oviService.getDeviceList(reqDeviceList);
        List<BraceletTrack> list = new ArrayList<>();
        for (int i = 0; i < listInfo.size(); i++) {
            PersonDeviceInfo personDeviceInfo = listInfo.get(i);
            BraceletTrack braceletTrack = new BraceletTrack();
            braceletTrack.setRecord_time(personDeviceInfo.getDeviceUtcTime());
            braceletTrack.setLon(personDeviceInfo.getLongitude());
            braceletTrack.setLat(personDeviceInfo.getLatitude());
            braceletTrack.setDevid(personDeviceInfo.getId());
            braceletTrack.setAt("0");
            list.add(braceletTrack);
        }
        return list;
    }

    @Override
    public List<BraceletStatus> getStatus(ReqIdList req) {
        return null;
    }

    @Override
    public Boolean setStatus(ReqSetStatus req) {
        return null;
    }

    @Override
    public List<BraceletInfo> getHrInfo(ReqIdList req) {
        return null;
    }

    @Override
    public List<BraceletInfo> getPositionInfo(ReqPositionInfo req) {
        return null;
    }

    @Override
    public Boolean setWarningInfo(WarningInfo req) {
        return null;
    }

    @Override
    public PushInfo getPushInfo() {
        return null;
    }
}
