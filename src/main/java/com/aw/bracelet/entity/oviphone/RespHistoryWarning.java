package com.aw.bracelet.entity.oviphone;

import java.util.List;

public class RespHistoryWarning {
    private Integer state;
    private List<ExceptionInfo> Items;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<ExceptionInfo> getItems() {
        return Items;
    }

    public void setItems(List<ExceptionInfo> items) {
        Items = items;
    }
}
