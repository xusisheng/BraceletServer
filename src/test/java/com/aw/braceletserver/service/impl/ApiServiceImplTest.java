package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.aw.braceletserver.BraceletServerApplication;
import com.aw.braceletserver.entity.BraceletTrack;
import com.aw.braceletserver.entity.LoginUserInfo;
import com.aw.braceletserver.entity.ReqGetList;
import com.aw.braceletserver.entity.UserInfo;
import com.aw.braceletserver.service.ApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BraceletServerApplication.class)
public class ApiServiceImplTest {

    @Autowired
    private ApiService apiService;

    private UserInfo userInfo;

    @Before
    public void setUp() throws Exception {
        userInfo = new UserInfo();
        userInfo.setAccessToken("74FBE649B34FC42CE01414B8556BFC86");
        LoginUserInfo info = new LoginUserInfo();
        info.setUserId(33845);
        userInfo.setItem(info);
    }

    @Test
    public void getHistoryLocation() {
        ReqGetList req = new ReqGetList();
        JSONArray ja = new JSONArray();
        ja.add(10000);
        ja.add(10001);
        req.setIdlist(ja);
        req.setLimit(10);
        req.setBegin_time("2020-01-01 00:00:01");
        req.setEnd_time("2020-05-01 00:00:01");
        List<BraceletTrack> list = apiService.getHistoryLocation(userInfo);
        System.out.println("===========");
    }

    @Test
    public void getStatus() {
    }

    @Test
    public void setStatus() {
    }

    @Test
    public void getHrInfo() {
    }

    @Test
    public void getPositionInfo() {
    }

    @Test
    public void setWarningInfo() {
    }

    @Test
    public void getPushInfo() {
    }
}