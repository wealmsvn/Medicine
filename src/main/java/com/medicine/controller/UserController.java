package com.medicine.controller;

import com.medicine.bean.User;
import com.medicine.service.UserService;
import com.medicine.vo.Result;
import com.medicine.vo.UserLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户登陆")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    @ApiOperation(value = "用户登陆接口")
    public Result login(UserLogin user){
//        需要绑定token到前台检验
        return Result.success(userService.queryUserName(user));
    }
}
