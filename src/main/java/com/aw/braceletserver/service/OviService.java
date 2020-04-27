package com.aw.braceletserver.service;

import com.aw.braceletserver.entity.oviphone.*;

import java.util.List;

public interface OviService {

    /**
     * 获取用户设备信息列表
     * @param req
     * @return
     */
    List<PersonDeviceInfo> getDeviceList(ReqDeviceList req);

    List<HistoryInfo> getHistoryLocation(ReqHistoryLocation req);

    RespHealth getHealth(ReqHealth req);

    RespSendCommad sendCommand(ReqSendCommand req);

    List<ExceptionInfo> getHistoryWarning(ReqHistoryWarning req);
}
