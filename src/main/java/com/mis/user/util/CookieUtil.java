package com.mis.user.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    public Object ReadCookievalue(HttpServletRequest request, HttpSession session){
        String user = null;
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) {
                    System.out.println(cookie.getValue());
                    user = (String) session.getAttribute(cookie.getValue());
                }else {
                    System.out.println("111111111111");
                    user = null;
                }
            }
        }
        return user;
    }
}
