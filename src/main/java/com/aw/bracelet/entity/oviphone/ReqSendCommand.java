package com.aw.bracelet.entity.oviphone;

public class ReqSendCommand extends OviBaseRequset {
    private String Token;
    private Integer DeviceId;
    private String DeviceModel;
    private String CmdCode;
    private String Params;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Integer getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(Integer deviceId) {
        DeviceId = deviceId;
    }

    public String getDeviceModel() {
        return DeviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        DeviceModel = deviceModel;
    }

    public String getCmdCode() {
        return CmdCode;
    }

    public void setCmdCode(String cmdCode) {
        CmdCode = cmdCode;
    }

    public String getParams() {
        return Params;
    }

    public void setParams(String params) {
        Params = params;
    }
}
