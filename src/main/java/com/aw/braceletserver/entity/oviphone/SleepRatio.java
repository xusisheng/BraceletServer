package com.aw.braceletserver.entity.oviphone;

public class SleepRatio {
    private Integer totalSec;
    private Integer deepSleepSec;
    private Integer lightSleepSec;
    private Integer roll;
    private Integer wake;
    private Integer qurlity;

    public Integer getTotalSec() {
        return totalSec;
    }

    public void setTotalSec(Integer totalSec) {
        this.totalSec = totalSec;
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

    public Integer getQurlity() {
        return qurlity;
    }

    public void setQurlity(Integer qurlity) {
        this.qurlity = qurlity;
    }
}
