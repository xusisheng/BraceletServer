package com.aw.bracelet.entity;

import com.alibaba.fastjson.JSONArray;

public class ReqResultList extends BaseEntity {
    private JSONArray result;

    public JSONArray getResult() {
        return result;
    }

    public void setResult(JSONArray result) {
        this.result = result;
    }
}
