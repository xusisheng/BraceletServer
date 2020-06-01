package com.aw.bracelet.entity.oviphone;

public class FenceConfig {
    private Boolean period;
    private String alarmType;
    private Integer maximum;
    private Boolean isNeedSwitch;

    public Boolean getPeriod() {
        return period;
    }

    public void setPeriod(Boolean period) {
        this.period = period;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Boolean getNeedSwitch() {
        return isNeedSwitch;
    }

    public void setNeedSwitch(Boolean needSwitch) {
        isNeedSwitch = needSwitch;
    }
}
