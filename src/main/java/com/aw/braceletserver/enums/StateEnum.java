package com.aw.braceletserver.enums;

public enum StateEnum {
    SUCCESS(0, "成功"),
    USER_NOT_EXIST(1000, "用户不存在"),
    DEVICE_NOT_EXIST(1100, "设备不存在"),
    DEVICE_BELONG_OWN(1105, "设备属于自己"),
    DEVICE_ACCESS(1106, "你已获得该设备访问权限"),
    DEVICE_APPLY_VIEW_WITH_MASTER_CONTROL_NUM(1107, "该设备已有主控号，你可以申请查看该设备"),
    DEVICE_HAS_APPLY_VIEW_WITH_MASTER_CONTROL_NUM(1500, "该设备存在主控号，并且已向主控号申请查看该设备请求"),
    DEVICE_FAIL_APPLY_VIEW_WITH_MASTER_CONTROL_NUM(1550, "该设备存在主控号，申请查看失败"),
    REPEAT_REQUEST(1501, "已提交相同的请求"),
    DEVICE_OFFLINE(1800, "设备不在线"),

    VERIFY_CODE_VERIFY(3900, "需要验证码验证"),
    VERIFY_CODE_NEED(3901, "需要输入验证码"),

    WATCH_NOT_INIT(4004, "手表还未初始化"),
    SIM_NOT_AVALIABLE(4005, "SIM卡无效"),
    SIM_NUM_HAS_KNOWN(4006, "SIM卡号码已知"),

    OTHER(9999, "其他"),
    ;

    private int code;

    private String desc;

    StateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
