package com.aw.bracelet.entity;

public class LoginUserInfo extends BaseEntity {
    private Integer UserId;
    private String Username;
    private String LoginName;
    private String Timezone;
    private String Avatar;
    private String Email;
    private Integer DeviceCount;
    private String CodeUrl;
    private Integer UserType;
    private Integer SubUsersCount;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getTimezone() {
        return Timezone;
    }

    public void setTimezone(String timezone) {
        Timezone = timezone;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getDeviceCount() {
        return DeviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        DeviceCount = deviceCount;
    }

    public String getCodeUrl() {
        return CodeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        CodeUrl = codeUrl;
    }

    public Integer getUserType() {
        return UserType;
    }

    public void setUserType(Integer userType) {
        UserType = userType;
    }

    public Integer getSubUsersCount() {
        return SubUsersCount;
    }

    public void setSubUsersCount(Integer subUsersCount) {
        SubUsersCount = subUsersCount;
    }
}
