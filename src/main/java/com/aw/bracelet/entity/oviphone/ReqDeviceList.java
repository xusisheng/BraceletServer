package com.aw.bracelet.entity.oviphone;

public class ReqDeviceList extends OviBaseRequset {
    private Integer UserId;
    private String MapType;
    private String Token;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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
}
