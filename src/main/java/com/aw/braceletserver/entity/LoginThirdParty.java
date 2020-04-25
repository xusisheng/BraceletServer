package com.aw.braceletserver.entity;

public class LoginThirdParty {
    private Integer UserID;
    private String ThirdImg;
    private String ThirdName;
    private Integer ThirdType;
    private Integer ThirdID;

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getThirdImg() {
        return ThirdImg;
    }

    public void setThirdImg(String thirdImg) {
        ThirdImg = thirdImg;
    }

    public String getThirdName() {
        return ThirdName;
    }

    public void setThirdName(String thirdName) {
        ThirdName = thirdName;
    }

    public Integer getThirdType() {
        return ThirdType;
    }

    public void setThirdType(Integer thirdType) {
        ThirdType = thirdType;
    }

    public Integer getThirdID() {
        return ThirdID;
    }

    public void setThirdID(Integer thirdID) {
        ThirdID = thirdID;
    }
}
