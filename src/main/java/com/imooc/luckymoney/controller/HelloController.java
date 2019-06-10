package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.entity.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Limit limit;

    @GetMapping("/money")
    public String hello() {
        return limit.getDesc();
    }
}
