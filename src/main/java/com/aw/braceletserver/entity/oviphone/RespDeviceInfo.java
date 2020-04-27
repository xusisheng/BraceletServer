package com.aw.braceletserver.entity.oviphone;

import java.util.List;

public class RespDeviceInfo {
    private Integer state;
    private String message;
    private List<PersonDeviceInfo> Items;
    private Integer exceptionCount;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PersonDeviceInfo> getItems() {
        return Items;
    }

    public void setItems(List<PersonDeviceInfo> items) {
        Items = items;
    }

    public Integer getExceptionCount() {
        return exceptionCount;
    }

    public void setExceptionCount(Integer exceptionCount) {
        this.exceptionCount = exceptionCount;
    }
}
