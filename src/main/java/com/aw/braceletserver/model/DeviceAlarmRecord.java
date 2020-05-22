package com.aw.braceletserver.model;

import java.math.BigDecimal;
import java.util.Date;

public class DeviceAlarmRecord {
    private Integer id;

    private Integer userId;

    private Integer deviceId;

    private String serialNumber;

    private String alarmName;

    private String alarmContent;

    private Integer alarmType;

    private Date createTime;

    private Integer isDelete;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String address;

    private String deviceName;

    private String modelName;

    private String nickname;

    private String avatar;

    private Integer geoFenceId;

    private String geoName;

    private Integer fenceNo;

    private BigDecimal olat;

    private BigDecimal olng;

    private Float altitude;

    private Integer battery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName == null ? null : alarmName.trim();
    }

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent == null ? null : alarmContent.trim();
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getGeoFenceId() {
        return geoFenceId;
    }

    public void setGeoFenceId(Integer geoFenceId) {
        this.geoFenceId = geoFenceId;
    }

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName == null ? null : geoName.trim();
    }

    public Integer getFenceNo() {
        return fenceNo;
    }

    public void setFenceNo(Integer fenceNo) {
        this.fenceNo = fenceNo;
    }

    public BigDecimal getOlat() {
        return olat;
    }

    public void setOlat(BigDecimal olat) {
        this.olat = olat;
    }

    public BigDecimal getOlng() {
        return olng;
    }

    public void setOlng(BigDecimal olng) {
        this.olng = olng;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }
}