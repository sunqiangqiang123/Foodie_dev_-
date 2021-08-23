package com.sun.service;

import com.sun.pojo.BO.UserBO;
import com.sun.pojo.model.SysUsers;

public interface UserService {


    /**
     * 判断用户是否存在
     */
    public boolean queryUserNameIsExist(String username);

    /**
     * 创建用户
     * @param userBO
     * @return
     */
    public SysUsers createUser(UserBO userBO);
}
