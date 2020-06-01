package com.aw.bracelet.entity.oviphone;

public class ReqHistoryLocation extends OviBaseRequset {
    private Integer DeviceId;
    private String MapType;
    private String Token;
    private Integer SelectCount;
    private String StartTime;
    private String EndTime;

    public Integer getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(Integer deviceId) {
        DeviceId = deviceId;
    }

    public String getMapType() {
        return MapType;
    }

    public void setMapType(String mapType) {
        MapType = mapType;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Integer getSelectCount() {
        return SelectCount;
    }

    public void setSelectCount(Integer selectCount) {
        SelectCount = selectCount;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }
}
