package com.ly.mybatis.dao;

import java.util.List;
import com.ly.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @InterfaceName BlogMapper
 * @description：
 * @author：liuyi
 * @Date：2021/8/3 11:56
 */
public interface UserMapper {
    List<User> selectUser(long id);

    @Select("select * from user where id = #{id}")
    List<User> annotationSelectUser(long id);

    @com.ly.mybatis.annotation.Select("select * from user where id = #{id}")
    List<User> customSelectUser(long id);

    @Insert("INSERT INTO `user` (`name`, `address`) VALUES (#{name},#{address})")
    Integer insertUser(User user);
}
