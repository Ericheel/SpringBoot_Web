package com.imooc.luckymoney.enums;

public enum ResponseEnum {
    UNKNOW_ERROR("-1", "未知错误"),
    SUCCESS("100", "成功"),
    ERROR("101", "失败"),
    ;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
