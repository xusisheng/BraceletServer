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

    /**
     * 历史轨迹
     * @param req
     * @return
     */
    List<HistoryInfo> getHistoryLocation(ReqHistoryLocation req);

    /**
     * 健康数据
     * @param req
     * @return
     */
    RespHealth getHealth(ReqHealth req);

    /**
     * 下发命令
     * @param req
     * @return
     */
    RespSendCommad sendCommand(ReqSendCommand req);

    /**
     * 历史异常告警信息
     * @param req
     * @return
     */
    List<ExceptionInfo> getHistoryWarning(ReqHistoryWarning req);
}
