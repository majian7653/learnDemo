package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @Deacription TODO
 * @Author majian
 * @Date 2020/12/7
 * @Version 1.0
 **/


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String insertUser(@RequestBody User user){
        System.out.println(user);
        return userService.insert(user).toString();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String GetUser( @PathVariable Integer id){
        return userService.selectById(id).toString();
    }

    /**
     * 跳转到应用列表页面
     * @param pageNo 要显示第几页内容
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping("/list")
    public PageInfo<User> list(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize) {
        PageInfo<User> page = userService.getAllUserForPage(pageNo,pageSize);
        return  page;
    }


}
