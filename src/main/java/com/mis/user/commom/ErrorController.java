//package com.mis.user.commom;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.method.HandlerMethod;
//
//@ControllerAdvice
//public class ErrorController {
//    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
//    @ExceptionHandler(Exception.class)
//    public Object handlerException(Exception e, HandlerMethod handlerMethod){
//        logger.info("统一异常处理，{}类的{}方法出现异常",handlerMethod.getBean().getClass(),handlerMethod.getMethod().getName());
//        return "error";
//    }
//}
//
//
