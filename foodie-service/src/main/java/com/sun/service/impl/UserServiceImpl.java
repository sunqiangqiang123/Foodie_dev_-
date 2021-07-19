package com.sun.service.impl;

import com.sun.mapper.SysUsersMapper;
import com.sun.pojo.model.SysUsers;
import com.sun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public SysUsersMapper sysUsersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUserNameIsExist(String username) {

        Example userExample = new Example(SysUsers.class);
        Example.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andEqualTo("username",username);
        SysUsers result = sysUsersMapper.selectOneByExample(userExample);

        return result == null ? false:true;
    }
}
