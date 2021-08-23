package com.sun.service.impl;

import com.sun.mapper.SysUsersMapper;
import com.sun.pojo.BO.UserBO;
import com.sun.pojo.model.SysUsers;
import com.sun.service.UserService;
import com.sun.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public SysUsersMapper sysUsersMapper;

    private static final String USER_FACE = "ddd";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUserNameIsExist(String username) {

        Example userExample = new Example(SysUsers.class);
        Example.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andEqualTo("username",username);
        SysUsers result = sysUsersMapper.selectOneByExample(userExample);

        return result == null ? false:true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public SysUsers createUser(UserBO userBO) {

        try {
            SysUsers sysUsers = new SysUsers();
            sysUsers.setUsername(userBO.getUsername());
            sysUsers.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
            sysUsers.setNickname(userBO.getUsername());//昵称默认用户名称
            sysUsers.setFace(USER_FACE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
