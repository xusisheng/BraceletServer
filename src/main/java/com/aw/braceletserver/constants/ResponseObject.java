package com.aw.braceletserver.constants;

import com.alibaba.fastjson.JSON;
import com.aw.braceletserver.enums.StateEnum;

import java.util.HashMap;
import java.util.Map;

public class ResponseObject {
    private static String CODE = "State";
    private static String MESSAGE = "Message";
    protected HashMap<String, Object> propMap;

    public ResponseObject() {
        this.propMap = new HashMap();
    }

    public Map<String, Object> getPropMap() {
        return this.propMap;
    }

    public void setStateCode(StateEnum stateEnum) {
        this.propMap.put(CODE, stateEnum.getCode());
    }

    public void setState(StateEnum stateEnum) {
        this.propMap.put(CODE, stateEnum.getCode());
        this.propMap.put(MESSAGE, stateEnum.getDesc());
    }

//    public void setState(String method, StateEnum stateEnum) {
//        this.propMap.put(CODE, stateEnum.getCode());
//        this.propMap.put(MESSAGE, method + stateEnum.getDesc());
//    }

    public void setState(int code, String desc) {
        this.propMap.put(CODE, code);
        this.propMap.put(MESSAGE, desc);
    }

    public void setString(String Tag, String Value) {
        this.propMap.put(Tag, Value);
    }

    public String getString(String Tag) {
        return (String)this.propMap.get(Tag);
    }

    public void setObject(String Tag, Object Value) {
        this.propMap.put(Tag, Value);
    }

    public Object getObject(String Tag) {
        return this.propMap.get(Tag);
    }

    public String toJSONString() {
        return JSON.toJSONString(this.propMap);
    }
}
