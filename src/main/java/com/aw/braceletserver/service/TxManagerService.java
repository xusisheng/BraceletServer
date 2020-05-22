package com.aw.braceletserver.service;

import com.alibaba.fastjson.JSONObject;

public interface TxManagerService {

    boolean uploadDeviceData(JSONObject data);
}
