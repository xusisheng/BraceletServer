package com.aw.bracelet.enums;

import org.apache.commons.lang.StringUtils;

public enum CommandEnum {
    DOWN_TIME_POSITION_PERIOD("1209", "下发定时定位频率时段"),
    SET_ALARM_CLOCK("1307", "设置闹钟"),
    DELETE_ALARM_CLOCK("1307", "删除闹钟"),
    REMOTE_TURN_OFF("0048", "远程关机"),
    DEVICE_OUTING_CALL("0084", "设备拨出电话"),
    HEART_RATE_MEASURE("1210", "测量心率"),
    BLUETOOTH_POSITION_PERIOD("8098", "蓝牙定位周期"),
    GPS_POSITION_PERIOD("8097", "GPS定位周期"),
    NB_UPLOAD_POSITION_PERIOD("8096", "NB上传定位周期"),
    LOWER_BATTERY_WARNING("8095", "低电量报警值"),
    STATIC_TO_DORMANT_TIME("8094", "静止到休眠时间值"),
    PRESET_PHONE("8093", "预设电话号码"),
    FAMILY_NUMBER("1319", "亲情号码设置"),
    SET_PHONE_BOOK("1320", "设置电话本"),
    DELETE_PHONE_BOOK("1320", "删除电话本"),
    TERMINAL_TIME_ZONE("0114", "设置终端时区"),

    SET_TIME_POSITION_PERIOD("NB01", "设置定时定位频率"),
    DELETE_TIME_POSITION_PERIOD("NB01", "删除定时定位频率"),
    TEMPERATURE_WARNING_VALUE("NB02", "设置温度报警阀值"),
    HEART_RATE_WARNING_VALUE("NB03", "心率报警阀值设置"),
    HEART_RATE_CHECK_PERIOD("NB04", "心率检测周期设置"),
    TEMPERATURE_CHECK_PERIOD("NB05", "温度检测周期设置"),
    HEART_BEAT("NB06", "心跳"),
    ;

    private String code;

    private String desc;

    CommandEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CommandEnum getCommandEnumByCode(String code){
        for (CommandEnum commandEnum : CommandEnum.values()) {
            if (StringUtils.equalsIgnoreCase(code, commandEnum.getCode())) {
                return commandEnum;
            }
        }
        return null;
    }
}
