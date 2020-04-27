package com.aw.braceletserver.entity.oviphone;

public class BloodPressure {
    private Integer diastolic;
    private Integer shrink;
    private String lastUpdate;

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public Integer getShrink() {
        return shrink;
    }

    public void setShrink(Integer shrink) {
        this.shrink = shrink;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
