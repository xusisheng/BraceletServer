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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BraceletApplication.class)
public class DeviceServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(DeviceServiceTest.class);

    @Autowired
    private DeviceService deviceService;

    @Test
    public void getDeviceBySn() {
        Device device = deviceService.getDeviceBySn("E862177041313118");
        System.out.println("OK");
    }
}