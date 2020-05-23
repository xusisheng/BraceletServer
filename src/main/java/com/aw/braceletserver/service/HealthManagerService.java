package com.aw.braceletserver.service;

import com.aw.braceletserver.model.Health;

import java.util.Date;
import java.util.List;

public interface HealthManagerService {

    Health addHealth(Health health);

    List<Health> getHealthByUserDevice(int userId, String deviceSerialNum, Date startTime, Date endTime);
}
