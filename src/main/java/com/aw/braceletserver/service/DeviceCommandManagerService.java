package com.aw.braceletserver.service;

import com.aw.braceletserver.constants.ResponseObject;
import com.aw.braceletserver.entity.DeviceCommand;
import com.aw.braceletserver.enums.CommandEnum;

import java.util.List;

public interface DeviceCommandManagerService {

    /**
     * 获取设备指令下一个id
     * @return
     */
    int selectNextId();

    /**
     * 保存指令
     * @param deviceId
     * @param deviceModel
     * @param commandEnum
     * @param params
     * @param responseObject
     * @return
     */
    boolean saveCommand(int deviceId, String deviceModel, CommandEnum commandEnum, String params, ResponseObject responseObject);

    /**
     * 查询指令列表
     * @param deviceId
     * @return
     */
    List<DeviceCommand> getCommandList(int deviceId);
}
