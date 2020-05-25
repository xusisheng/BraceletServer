package com.aw.braceletserver.service.impl;

import com.aw.braceletserver.BraceletServerApplication;
import com.aw.braceletserver.service.IotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BraceletServerApplication.class)
public class IotServiceImplTest {

    @Autowired
    private IotService iotService;

    @Test
    public void createDeviceCommand() throws Exception {
        iotService.CreateDeviceCommand();
    }
}