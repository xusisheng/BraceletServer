package com.aw.braceletserver.model;

import java.util.Date;

public class Health {
    private String id;

    private String deviceSerialNum;

    private Integer userId;

    private Float bloodSugar;

    private Date createTime;

    private Float disastolic;

    private Float shrink;

    private Float heartBeat;

    private Integer steps;

    private Float bloodPressure;

    private Float bodyTemperature;

    private Integer deepSleepSec;

    private Integer lightSleepSec;

    private Integer roll;

    private Integer wake;

    private Integer quality;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceSerialNum() {
        return deviceSerialNum;
    }

    public void setDeviceSerialNum(String deviceSerialNum) {
        this.deviceSerialNum = deviceSerialNum == null ? null : deviceSerialNum.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Float bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getDisastolic() {
        return disastolic;
    }

    public void setDisastolic(Float disastolic) {
        this.disastolic = disastolic;
    }

    public Float getShrink() {
        return shrink;
    }

    public void setShrink(Float shrink) {
        this.shrink = shrink;
    }

    public Float getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Float heartBeat) {
        this.heartBeat = heartBeat;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Float getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(Float bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public Integer getDeepSleepSec() {
        return deepSleepSec;
    }

    public void setDeepSleepSec(Integer deepSleepSec) {
        this.deepSleepSec = deepSleepSec;
    }

    public Integer getLightSleepSec() {
        return lightSleepSec;
    }

    public void setLightSleepSec(Integer lightSleepSec) {
        this.lightSleepSec = lightSleepSec;
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
}