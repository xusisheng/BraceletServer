package com.aw.braceletserver.entity;

/**
 * 手环状态
 */
public class BraceletStatus {
    /**
     * 状态信息
     */
    private Boolean isonline;
    /**
     * 手环号
     */
    private String devid;

    public Boolean getIsonline() {
        return isonline;
    }

    public void setIsonline(Boolean isonline) {
        this.isonline = isonline;
    }

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }
}