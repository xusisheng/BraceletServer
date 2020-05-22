package com.aw.braceletserver.service;

import com.aw.braceletserver.entity.Health;

import java.util.List;

public interface HealthManagerService {

    Health addHealth(Health health);

    List<Health> getHealthByUserDevice(int userId, String deviceSerialNum, String startTime, String endTime) throws Exception;
}
