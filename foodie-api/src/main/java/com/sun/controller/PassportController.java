package com.sun.controller;

import com.sun.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public HttpStatus userNameIsExist(@RequestParam String username){

        //1 判断用户名不能为空
        if(StringUtils.isBlank(username)){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        //2 查找注册用户名是否存在
        boolean isExist =  userService.queryUserNameIsExist(username);
        if(isExist){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        //3请求成功,用户名字没有重复
        return HttpStatus.OK;
    }
}