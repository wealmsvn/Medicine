package com.medicine.service.impl;

<<<<<<< HEAD
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medicine.bean.*;
import com.medicine.dao.UserDao;
import com.medicine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectOneUserById(Integer id) {
        User user = userDao.selectOneUserById(id);
        return user;
    }

    @Override
    public int updateUserInfo(User user) {

        return userDao.updateUserInfo(user);
    }

    @Override
    public int updatePhoto(String newName, Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("photo",newName);
        map.put("id",id);
        return userDao.updatePhoto(map);
    }

    @Override
    public List<UserStudyHistory> selectUserStudyHistory(String phoneNum) {
        return userDao.selectUserStudyHistory(phoneNum);
    }

    @Override
    public List<SchoolInfo> selectSchoolName() {
        return userDao.selectSchoolName();
    }

    @Override
    public int applyTeacher(Teacher teacher) {
        return userDao.applyTeacher(teacher);
    }

    @Override
    public List<Professional> selectselectProfessionalName() {
        return userDao.selectselectProfessionalName();
    }

    @Override
    public int validPassword(User user) {
        return userDao.validPassword(user);
    }

    @Override
    public int updatePassword(User user) {

        return userDao.updatePassword(user);
=======
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medicine.bean.User;
import com.medicine.dao.UserDao;
import com.medicine.service.UserService;
import com.medicine.vo.Result;
import com.medicine.vo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    JedisPool jedisPool;

    @Override
    public Result queryUserName(UserLogin user) {
        Jedis jedis = jedisPool.getResource();
        User user1 = null;

        //判断用户是否存在
        if (jedis.exists(user.getMobile())) {
            System.out.println("缓存中取登陆数据");
            String s = jedis.get(user.getMobile());
            return Result.success(s);

        } else {
            System.out.println("数据库中取数据");
            int i = getBaseMapper().selectUser(user);
            if (i > 0) {
                //      查询用户的信息
                user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("mobile", user.getMobile()));
                System.out.println(user1);
                jedis.set(user.getMobile(),user1.getMobile());
            }
        }
        return Result.error(null);
>>>>>>> github/master
    }
}
