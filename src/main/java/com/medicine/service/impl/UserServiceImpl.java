package com.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medicine.bean.User;
import com.medicine.dao.UserDao;
import com.medicine.service.UserService;
import com.medicine.vo.Result;
import com.medicine.vo.UserLogin;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService  {

    @Override
    public Result queryUserName(UserLogin user) {

        int i =getBaseMapper().selectUser(user);
       //判断用户是否存在
        if(i > 0){
//            将登陆的信息放入到
            return Result.success(i);
        }
        return Result.error(null);
    }
}
