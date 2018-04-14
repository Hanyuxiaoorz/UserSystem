package com.mis.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * CreatedBy: dengsiyuan
 * On: 2018/4/13.
 * you are the best! do more and more.
 * describle:
 */
@RestController
public class UserController {
    @GetMapping("hello")
    public Map<String,String> demo(){
        Map map = new HashMap();
        map.put("message", "hello");
        return map;
    }
}