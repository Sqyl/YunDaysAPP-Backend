package cn.sqyl.controller;

import cn.sqyl.response.Result;
import cn.sqyl.service.UserService;
import cn.sqyl.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/getFriendById")
    public Result getFriendById(@RequestBody UserModel userModel){
        //调用service服务获取对应id的用户对象并返回给前端
        return userService.getFriendById(userModel);

    }

    @PostMapping(value = "/register")
    public Result register(@RequestBody UserModel userModel){
        //用户注册流程

        return userService.register(userModel);
    }

    @PostMapping(value = "/login")

    public Result login(@RequestBody UserModel userModel) {

        return userService.login(userModel);
    }


}
