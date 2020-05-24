package com.aw.braceletserver.entity;

import java.util.Date;

/**
 * 手环推送信息
 */
public class PushInfo {
    /**
     * 消息类型1 sos 0gps
     */
    private Integer type;
    /**
     * 海拔
     */
    private String altitude;
    /**
     * 舒张压  mmHg
     */
    private Float dbp;
    /**
     * 收缩压  mmHg
     */
    private Float sbp;
    /**
     * 设备id
     */
    private String deviceId;
    /**
     * 方向角
     */
    private Integer direction;
    /**
     * 心跳
     */
    private Integer heartRate;
    /**
     * 经度
     */
    private String lon;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 速度
     */
    private Integer speed;
    /**
     * 获取时间，毫秒数
     */
    private Long upTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public Float getDbp() {
        return dbp;
    }

    public void setDbp(Float dbp) {
        this.dbp = dbp;
    }

    public Float getSbp() {
        return sbp;
    }

    public void setSbp(Float sbp) {
        this.sbp = sbp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Long getUpTime() {
        return upTime;
    }

    public void setUpTime(Long upTime) {
        this.upTime = upTime;
    }
}