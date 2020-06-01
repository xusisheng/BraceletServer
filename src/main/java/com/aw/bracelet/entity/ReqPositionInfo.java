package com.aw.bracelet.entity;

/**
 * 手环位置心率数据根据中心点半径实时查询接口请求
 */
public class ReqPositionInfo {
    /**
     * 经度
     */
    private String lon;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 半径（单位：米）
     */
    private String radio;
    /**
     * 海拔
     */
    private String at;

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

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }
}