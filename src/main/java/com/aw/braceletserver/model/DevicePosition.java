package com.aw.braceletserver.model;

import java.math.BigDecimal;
import java.util.Date;

public class DevicePosition {
    private Integer id;

    private Integer deviceId;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private BigDecimal oLatitude;

    private BigDecimal oLongitude;

    private Date deviceUtcTime;

    private Integer positionType;

    private Float altitude;

    private Integer onlineStatus;

    private BigDecimal atmosphere;

    private Integer battery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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

    public BigDecimal getoLatitude() {
        return oLatitude;
    }

    public void setoLatitude(BigDecimal oLatitude) {
        this.oLatitude = oLatitude;
    }

    public BigDecimal getoLongitude() {
        return oLongitude;
    }

    public void setoLongitude(BigDecimal oLongitude) {
        this.oLongitude = oLongitude;
    }

    public Date getDeviceUtcTime() {
        return deviceUtcTime;
    }

    public void setDeviceUtcTime(Date deviceUtcTime) {
        this.deviceUtcTime = deviceUtcTime;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
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
}