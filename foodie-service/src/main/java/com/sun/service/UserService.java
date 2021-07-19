package com.sun.service;

public interface UserService {


    /**
     * 判断用户是否存在
     */
    public boolean queryUserNameIsExist(String username);
}
