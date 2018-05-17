package com.zimo.wangbangqi.enums;

public enum GirlStatusEnum {
    /**正常的*/
    NORMAL("NORMAL"),
    /**禁用的*/
    DISABLED("DISABLED"),
    /**已删除的*/
    DELETED("DELETED");

    private String value;
    GirlStatusEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (GirlStatusEnum userStatusEnum : GirlStatusEnum.values()) {
            if (userStatusEnum.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
