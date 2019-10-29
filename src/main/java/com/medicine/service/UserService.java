package com.medicine.service;

<<<<<<< HEAD

import com.baomidou.mybatisplus.extension.service.IService;
import com.medicine.bean.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService extends IService<User> {
    User selectOneUserById(Integer id);

    int updateUserInfo(User user);

    int updatePhoto(String newName, Integer id);

    List<UserStudyHistory> selectUserStudyHistory(String phoneNum);

    List<SchoolInfo> selectSchoolName();

    int applyTeacher(Teacher teacher);

    List<Professional> selectselectProfessionalName();

    int validPassword(User user);

    int updatePassword(User user);
=======
import com.baomidou.mybatisplus.extension.service.IService;
import com.medicine.bean.User;
import com.medicine.vo.UserLogin;

public interface UserService extends IService<User> {
    Object queryUserName(UserLogin user);
>>>>>>> github/master
}
