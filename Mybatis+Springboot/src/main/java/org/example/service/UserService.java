package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.entity.User;

import java.util.List;

public interface UserService {

    Integer insert(User user);

    Integer deleteById(Integer id);


    User selectById(int id);

    List<User> getAllUser();

    PageInfo<User> getAllUserForPage(int pageNo, int pageSize);
}
