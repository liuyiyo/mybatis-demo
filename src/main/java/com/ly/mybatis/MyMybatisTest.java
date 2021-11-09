package com.ly.mybatis;

import com.ly.mybatis.dao.UserMapper;
import com.ly.mybatis.entity.User;
import com.ly.mybatis.proxy.MapperProxy;

import java.util.List;

/**
 * @ClassName MyMybatisTest
 * @description： 自定义mybtais测试
 * @author：liuyi
 * @Date：2021/11/8 11:25
 */
public class MyMybatisTest {
    public static void main(String[] args) {
        UserMapper userMapper = MapperProxy.getInstance(UserMapper.class);
        List<User> users = userMapper.customSelectUser(1);
    }
}
