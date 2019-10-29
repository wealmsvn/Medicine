package com.medicine.service.impl;

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
    }
}
