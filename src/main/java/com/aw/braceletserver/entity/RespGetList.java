package com.aw.braceletserver.entity;

public class RespGetList<T> extends UnifyResponse {
    private Integer total_num;

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }
}
