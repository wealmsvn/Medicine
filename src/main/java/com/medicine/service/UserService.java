package com.medicine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.medicine.bean.User;
import com.medicine.vo.UserLogin;

public interface UserService extends IService<User> {
    Object queryUserName(UserLogin user);
}
