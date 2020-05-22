package com.aw.braceletserver.service;

import com.alibaba.fastjson.JSONObject;
import com.aw.braceletserver.constants.ResponseObject;
import com.aw.braceletserver.entity.DeviceGeofence;

import java.util.List;

public interface GeofenceManagerService {

    int getNextGeofenceId();

    List<DeviceGeofence> getListByDeviceId(int deviceId);

    DeviceGeofence createDeviceGeofence(JSONObject item);

    DeviceGeofence editDeviceGeofence(JSONObject item);

    boolean deleteDeviceGeofence(int userId, int fenceId, ResponseObject responseObject);
}
