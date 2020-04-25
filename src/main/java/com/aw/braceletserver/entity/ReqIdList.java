package com.aw.braceletserver.entity;

import com.alibaba.fastjson.JSONArray;

public class ReqIdList extends BaseEntity {
    private JSONArray idlist;

    public JSONArray getIdlist() {
        return idlist;
    }

    public void setIdlist(JSONArray idlist) {
        this.idlist = idlist;
    }
}
