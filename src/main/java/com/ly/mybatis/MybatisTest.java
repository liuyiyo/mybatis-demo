package com.ly.mybatis;

import com.ly.mybatis.dao.UserMapper;
import com.ly.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName SqlSessionDemo
 * @description：
 * @author：liuyi
 * @Date：2021/8/3 11:42
 */
public class MybatisTest {
    public final static Logger logger = LoggerFactory.getLogger(MybatisTest.class);
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.annotationSelectUser(1);
        users.forEach(System.out::println);
//        User user = new User();
//        user.setName("六一");
//        user.setAddress("重庆");
//        Integer integer = mapper.insertUser(user);
//        System.out.println(integer);
    }
}
