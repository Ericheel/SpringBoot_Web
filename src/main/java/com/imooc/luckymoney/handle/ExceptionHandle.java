package com.imooc.luckymoney.handle;

import com.imooc.luckymoney.exception.LuckyException;
import com.imooc.luckymoney.utils.ResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public com.imooc.luckymoney.entity.ResponseBody handle(Exception e) {
        if (e instanceof LuckyException) {
            LuckyException luckyException = (LuckyException) e;
            return ResponseUtil.error(luckyException.getCode(), luckyException.getMessage());
        }
        return ResponseUtil.error("-1", "未知错误");
    }
}
