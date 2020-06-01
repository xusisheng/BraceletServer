package com.aw.bracelet.service;

import com.aw.bracelet.BraceletApplication;
import com.aw.bracelet.model.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BraceletApplication.class)
public class UserDeviceServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(UserDeviceServiceTest.class);

    @Autowired
    private DeviceService deviceService;

    @Test
    public void insert() {
    }

    @Test
    public void selectByIdSet() {
        String[] ids = {"1000", "10125"};
        List<Device> list = deviceService.selectBySnSet(33845L, ids);
        logger.debug("OK");
    }
}