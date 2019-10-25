package com.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medicine.bean.User;
import com.medicine.vo.UserLogin;

public interface UserDao extends BaseMapper<User> {
   int  selectUser(UserLogin user);
}
