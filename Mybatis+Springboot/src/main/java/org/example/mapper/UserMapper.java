package org.example.mapper;

import com.github.pagehelper.PageInfo;
import org.example.entity.User;
import org.springframework.stereotype.Repository;

import java.awt.print.PrinterGraphics;
import java.util.List;

@Repository
public interface UserMapper {

    /**
    * @Description //通过用户id查询用户信息
    * @Date 2020/12/8
    * @Param [id]
    * @return org.example.entity.User
    **/
    User selectById(int id);

    /**
    * @Description //查询所有记录
    * @Date 2020/12/8
    * @Param []
    * @return java.util.List<org.example.entity.User>
    **/
    List<User> getAllUser();

    PageInfo<User> getAllUserForPage(int pageNo, int pageSize);

    /**
    * @Description //插入一条记录，同时返回自增主键
    * @Date 2020/12/8
    * @Param [user]
    * @return java.lang.Integer
    **/
    Integer insert(User user);

    /**
    * @Description //通过用户id删除
    * @Date 2020/12/8
    * @Param [id]
    * @return java.lang.Integer
    **/
    Integer deleteById(Integer id);

    /**
    * @Description //通过用户id更新
    * @Date 2020/12/8
    * @Param [id]
    * @return java.lang.Integer
    **/
//    Integer updateById(Integer id);


}
