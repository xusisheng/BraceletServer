package com.aw.braceletserver.entity;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * 经纬度坐标
 */
public class Coordinate {
    private BigDecimal longitude;
    private BigDecimal latitude;

    public Coordinate() {}

    /**
     * 经纬度字符串格式
     * E4294967296 N0429496729
     * E110.308205 N025.262453
     *
     * @param coordinate
     */
    public Coordinate(String coordinate) {
        String[] items = coordinate.split(" ");
        try {
            if (StringUtils.isNotBlank(items[0])) {
                String sss = items[0].substring(1);
                longitude = new BigDecimal(items[0].substring(1));
            }
            if (StringUtils.isNotBlank(items[1])) {
                latitude = new BigDecimal(items[1].substring(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCoordinate(String coordinate) {
        String[] items = coordinate.split(" ");
        try {
            if (StringUtils.isNotBlank(items[0])) {
                String sss = items[0].substring(1);
                longitude = new BigDecimal(items[0].substring(1));
            }
            if (StringUtils.isNotBlank(items[1])) {
                latitude = new BigDecimal(items[1].substring(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
