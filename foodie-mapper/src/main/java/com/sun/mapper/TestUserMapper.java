package com.sun.mapper;

import com.sun.pojo.model.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface TestUserMapper extends MyMapper<TestUser> {

}