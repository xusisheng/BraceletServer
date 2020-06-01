package com.aw.bracelet.service;

import com.aw.bracelet.entity.*;

import java.util.List;

public interface ApiService {
    List<BraceletTrack> getHistoryLocation(UserInfo userInfo);

    List<BraceletStatus> getStatus(ReqIdList req);

    Boolean setStatus(ReqSetStatus req);

    List<BraceletInfo> getHrInfo(ReqIdList req);

    List<BraceletInfo> getPositionInfo(ReqPositionInfo req);

    Boolean setWarningInfo(WarningInfo req);

    PushInfo getPushInfo();
}
