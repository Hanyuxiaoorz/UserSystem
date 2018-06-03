package com.mis.user.intercecptor;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.user.annotation.Permission;
import com.mis.user.result.JsonResult;
import com.mis.user.result.ResultCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 拦截器，防止直接访问内部方法，使其直接访问到数据
 * @Author: Genius_DSY
 * @Date: 30th,May
 * */

@Aspect
@Component
public class ControllerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    @Value("${spring.profiles}")
    private String env;
    /**
     * 定义拦截规则：拦截com.mis.user.*.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.mis.user.*.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut(){}
    /**
     * 拦截器具体实现
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()")//制定拦截规则，也可以将@Pointcut中的内容放入其中
    public Object Interceptor(ProceedingJoinPoint pjp){
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();//获取被拦截的方法
        String methodName = method.getName();//获取被拦截的方法名

        Set<Object> allParams = new LinkedHashSet<>();//保存所有请求参数，用于输出到日志中

        logger.info("请求开始，方法：{}",methodName);

        Object result = null;

        Object[] args = pjp.getArgs();
        for(Object arg : args){
            if(arg instanceof Map<?,?>){
                //提取日志中的map参数，用于记录进日志
                @SuppressWarnings("unchecked")
                Map<String ,Object> map = (Map<String, Object>) arg;

                allParams.add(map);
            }else if (arg instanceof HttpServletRequest){
                HttpServletRequest request = (HttpServletRequest) arg;
                if(!isLogin(request)){
                    result = new JsonResult(ResultCode.NOT_LOGIN, "该操作需要登录！去登录吗?（不知道登录账号？请联系管理员。）", null);
                }

                //获取query String 或 posted from data 参数
                Map<String,String []> paramMap = request.getParameterMap();
                if(paramMap != null && paramMap.size() > 0){
                    allParams.add(paramMap);
                }
            }else if(arg instanceof HttpServletResponse){
                //do nothing...
            }else {
                //allParam.add(arg)
                allParams.add(arg);
            }
        }

        try{
            if(result == null){
                //一切正常情况下，继续执行被拦截方法
                result = pjp.proceed();
            }
        }catch (Throwable e){
            logger.info("exception:",e);
            result = new JsonResult(ResultCode.EXCEPTION,"发生异常："+ e.getMessage());
        }

        if(result instanceof JsonResult){
            long costMs = System.currentTimeMillis() - beginTime;
            logger.info("{}请求结束，耗时：{}ms",methodName,costMs);
        }
        return result;
    }

    //判断是否已经登录
    private boolean isLogin(HttpServletRequest request) {
        String token = (String) request.getSession().getAttribute("token");
        if(token != null){
            return true;
        }
        else {
            return false;
        }
    }
}