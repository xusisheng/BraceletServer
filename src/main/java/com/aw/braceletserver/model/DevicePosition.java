package com.aw.braceletserver.model;

import java.math.BigDecimal;
import java.util.Date;

public class DevicePosition {
    private Long id;

    private Long deviceId;

    private Long userId;

    private Date uptime;

    private String messageType;

    private Integer locateMode;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal altitude;

    private BigDecimal atmosphere;

    private Integer battery;

    private Integer heartBeat;

    private Double disastolic;

    private Double shrink;

    private Double bloodPressure;

    private Double bloodSugar;

    private Double temperature;

    private Integer steps;

    private Integer deepSleep;

    private Integer lightSleep;

    private Integer roll;

    private Integer wake;

    private Integer quality;

    private Boolean onlineStatus;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType == null ? null : messageType.trim();
    }

    public Integer getLocateMode() {
        return locateMode;
    }

    public void setLocateMode(Integer locateMode) {
        this.locateMode = locateMode;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public BigDecimal getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(BigDecimal atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Integer getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Integer heartBeat) {
        this.heartBeat = heartBeat;
    }

    public Double getDisastolic() {
        return disastolic;
    }

    public void setDisastolic(Double disastolic) {
        this.disastolic = disastolic;
    }

    public Double getShrink() {
        return shrink;
    }

    public void setShrink(Double shrink) {
        this.shrink = shrink;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getDeepSleep() {
        return deepSleep;
    }

    public void setDeepSleep(Integer deepSleep) {
        this.deepSleep = deepSleep;
    }

    public Integer getLightSleep() {
        return lightSleep;
    }

    public void setLightSleep(Integer lightSleep) {
        this.lightSleep = lightSleep;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public Integer getWake() {
        return wake;
    }

    public void setWake(Integer wake) {
        this.wake = wake;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}