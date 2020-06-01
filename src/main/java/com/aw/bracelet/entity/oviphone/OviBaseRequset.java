package com.aw.bracelet.entity.oviphone;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PascalNameFilter;

public class OviBaseRequset {

    public String toJson() {
//        return JSON.toJSONString(this);
        return JSON.toJSONString(this, new PascalNameFilter());
    }
}
