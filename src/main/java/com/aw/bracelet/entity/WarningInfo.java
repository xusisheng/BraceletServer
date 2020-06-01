package com.aw.bracelet.entity;

/**
 * 手环告警事件阈值设置
 */
public class WarningInfo extends BaseEntity {
    /**
     * 告警类型（1 心率）
     */
    private Integer type;
    /**
     * 告警值(格式：最小值-最大值)
     */
    private String valueinfo;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValueinfo() {
        return valueinfo;
    }

    public void setValueinfo(String valueinfo) {
        this.valueinfo = valueinfo;
    }
}