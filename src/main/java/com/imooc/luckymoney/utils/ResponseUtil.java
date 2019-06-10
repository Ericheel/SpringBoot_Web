package com.imooc.luckymoney.utils;

import com.imooc.luckymoney.entity.ResponseBody;

public class ResponseUtil {
    private ResponseUtil() {
    }

    public static ResponseBody success(String code, String message, Object object) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setCode(code);
        responseBody.setMessage(message);
        responseBody.setBody(object);
        return responseBody;
    }

    public static ResponseBody error(String code, String message) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setCode(code);
        responseBody.setMessage(message);
        return responseBody;
    }
}
