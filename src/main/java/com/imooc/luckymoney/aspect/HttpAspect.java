package com.imooc.luckymoney.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAspect {

    private final Logger logger = LoggerFactory.getLogger(HttpServlet.class);

    @Pointcut("execution(public * com.imooc.luckymoney.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        logger.info("URL={}", request.getRequestURL());
        logger.info("Method={}", request.getMethod());
        logger.info("ip={}", request.getRemoteAddr());
        logger.info("classMethod={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void after() {
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void afterReturning(Object object) {
        logger.info("response={}", object);
    }


}
