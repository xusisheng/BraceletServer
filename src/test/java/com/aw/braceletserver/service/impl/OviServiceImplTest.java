package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.BraceletServerApplication;
import com.aw.braceletserver.entity.oviphone.*;
import com.aw.braceletserver.service.OviService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BraceletServerApplication.class)
public class OviServiceImplTest {

    @Autowired
    private OviService oviService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDeviceList() {
        ReqDeviceList req = new ReqDeviceList();
        req.setToken("74FBE649B34FC42CE01414B8556BFC86");
        req.setUserId(33845);
        req.setMapType("");
        System.out.println(req.toJson());
        List<PersonDeviceInfo> list = oviService.getDeviceList(req);
        System.out.println(list.size());
    }

    @Test
    public void getHistoryLocation() {
        ReqHistoryLocation req = new ReqHistoryLocation();
        req.setToken("74FBE649B34FC42CE01414B8556BFC86");
        req.setDeviceId(59834);
        req.setMapType("");
        req.setSelectCount(10);
        req.setStartTime("2020-01-01 00:00:01");
        req.setEndTime("2020-05-01 00:00:01");
        List<HistoryInfo> list = oviService.getHistoryLocation(req);
    }

    @Test
    public void getHealth() {
        ReqHealth req = new ReqHealth();
        req.setToken("74FBE649B34FC42CE01414B8556BFC86");
        req.setDeviceId(59834);
        req.setStartTime("2020-01-01 00:00:01");
        req.setEndTime("2020-05-01 00:00:01");
        RespHealth respHealth = oviService.getHealth(req);
    }

    @Test
    public void sendCommand() {
        ReqSendCommand req = new ReqSendCommand();
        RespSendCommad respSendCommad = oviService.sendCommand(req);
    }

    @Test
    public void getHistoryWarning() {
        ReqHistoryWarning req = new ReqHistoryWarning();
        req.setID(33845);
        req.setTypeID(0);
        req.setPageNo(5);
        req.setPageCount(100);
        List<ExceptionInfo> list = oviService.getHistoryWarning(req);
    }
}