package com.imooc.luckymoney.exception;


import com.imooc.luckymoney.enums.ResponseEnum;

public class LuckyException extends RuntimeException {

    private String code;

    public LuckyException(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
