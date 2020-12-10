package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.entity.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Deacription TODO
 * @Author majian
 * @Date 2020/12/7
 * @Version 1.0
 **/


@RestController
@RequestMapping("/api/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String insertUser(@RequestBody User user){
        return userService.insert(user).toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id){
        logger.info("deleteUser");
        return userService.deleteById(id).toString();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String GetUser( @PathVariable Integer id){
        logger.debug(String.format("查询用户%s信息",id.toString()));
        return userService.selectById(id).toString();
    }

    /**
     * 跳转到应用列表页面
     * @param pageNo 要显示第几页内容
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo<User> list(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize) {
        PageInfo<User> page = userService.getAllUserForPage(pageNo,pageSize);
        return  page;
    }

}
