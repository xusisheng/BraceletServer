package com.aw.bracelet.entity.oviphone;

public class TemperInfo {
    private String IMEI;
    private Integer steps;
    private Integer heartbeat;
    private Integer bloodPressure;
    private Integer bodyTemperature;
    private Integer diastolic;
    private Integer shrink;
    private String lastUpdate;
    private Integer bloodSugar;

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Integer heartbeat) {
        this.heartbeat = heartbeat;
    }

    public Integer getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(Integer bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

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

    public Integer getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Integer bloodSugar) {
        this.bloodSugar = bloodSugar;
    }
}
