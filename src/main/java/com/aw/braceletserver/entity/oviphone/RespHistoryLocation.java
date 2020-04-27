package com.aw.braceletserver.entity.oviphone;

import java.util.List;

public class RespHistoryLocation {
    private Integer state;
    private List<HistoryInfo> items;
    private Integer lastLocationId;
    private String lastDeviceUtcDate;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<HistoryInfo> getItems() {
        return items;
    }

    public void setItems(List<HistoryInfo> items) {
        this.items = items;
    }

    public Integer getLastLocationId() {
        return lastLocationId;
    }

    public void setLastLocationId(Integer lastLocationId) {
        this.lastLocationId = lastLocationId;
    }

    public String getLastDeviceUtcDate() {
        return lastDeviceUtcDate;
    }

    public void setLastDeviceUtcDate(String lastDeviceUtcDate) {
        this.lastDeviceUtcDate = lastDeviceUtcDate;
    }
}
