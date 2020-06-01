package com.aw.bracelet.entity.oviphone;

import java.util.List;

public class RespHealth {
    private Integer state;
    private Integer stepCount;
    private SleepRatio sleepRatio;
    private List<HealthInfo> heartItems;
    private List<BloodPressure> bloodPressureItems;
    private List<BloodSugarInfo> bloodSugarItems;
    private List<TemperInfo> temperatureItems;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStepCount() {
        return stepCount;
    }

    public void setStepCount(Integer stepCount) {
        this.stepCount = stepCount;
    }

    public SleepRatio getSleepRatio() {
        return sleepRatio;
    }

    public void setSleepRatio(SleepRatio sleepRatio) {
        this.sleepRatio = sleepRatio;
    }

    public List<HealthInfo> getHeartItems() {
        return heartItems;
    }

    public void setHeartItems(List<HealthInfo> heartItems) {
        this.heartItems = heartItems;
    }

    public List<BloodPressure> getBloodPressureItems() {
        return bloodPressureItems;
    }

    public void setBloodPressureItems(List<BloodPressure> bloodPressureItems) {
        this.bloodPressureItems = bloodPressureItems;
    }

    public List<BloodSugarInfo> getBloodSugarItems() {
        return bloodSugarItems;
    }

    public void setBloodSugarItems(List<BloodSugarInfo> bloodSugarItems) {
        this.bloodSugarItems = bloodSugarItems;
    }

    public List<TemperInfo> getTemperatureItems() {
        return temperatureItems;
    }

    public void setTemperatureItems(List<TemperInfo> temperatureItems) {
        this.temperatureItems = temperatureItems;
    }
}
