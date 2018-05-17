package com.zimo.wangbangqi.enums;

/**
 * 枚举返回。
 */
public enum  ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    PRIMARY_SCHOOL(100,"还在上小学"),
    MIDDLE_SCHOOL(101,"还在上初中"),
    FAIL(127,"失败"),
    NO_RIGHTS(300,"权限不足")
    ;


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
