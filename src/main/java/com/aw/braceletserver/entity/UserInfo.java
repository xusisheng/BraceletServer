package com.aw.braceletserver.entity;

public class UserInfo extends BaseEntity {
    private Integer loginType;
    private String accessToken;
    private LoginUserInfo Item;
    private LoginThirdParty ThirdParty;
    private Integer state;

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LoginUserInfo getItem() {
        return Item;
    }

    public void setItem(LoginUserInfo item) {
        Item = item;
    }

    public LoginThirdParty getThirdParty() {
        return ThirdParty;
    }

    public void setThirdParty(LoginThirdParty thirdParty) {
        ThirdParty = thirdParty;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
