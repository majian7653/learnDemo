package org.example.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Deacription TODO
 * @Author majian
 * @Date 2020/12/7
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public Integer insert(User user) {
        userMapper.insert(user);
        return  user.getId();
    }

    @Override
    public Integer deleteById(Integer id) {
        Integer result = userMapper.deleteById(id);
        return result;
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public PageInfo<User> getAllUserForPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> allUserList = userMapper.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(allUserList);
        return pageInfo;
    }

}
