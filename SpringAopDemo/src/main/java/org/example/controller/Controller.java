package org.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Deacription TODO
 * @Author majian
 * @Date 2020/12/6
 * @Version 1.0
 **/

@RestController
@RequestMapping("/aopController")
public class Controller {


    @RequestMapping(value = "/Curry")
    public String Curry(){
        System.out.println("库里上场打球了！！");
        return "库里上场打球了！！";
    }

    @RequestMapping(value = "/Harden")
    public String Harden(){
        System.out.println("哈登上场打球了！！");
        return "哈登上场打球了！！";
    }

    @RequestMapping(value = "/Antetokounmpo")
    public String  Antetokounmpo(){
        System.out.println("字母哥上场打球了！！");
        return "字母哥上场打球了！！";
    }

    @RequestMapping(value = "/Jokic")
    public String Jokic(){
        System.out.println("约基奇上场打球了！！");
        return "约基奇上场打球了！！";
    }

    @RequestMapping(value = "/Durant/{point}")
    public void Durant(@PathVariable("point")  int point){
        System.out.println("杜兰特上场打球了！"+ point);
//        return "杜兰特上场打球了！！";
    }

}
