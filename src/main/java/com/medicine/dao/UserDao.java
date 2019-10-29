package com.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medicine.bean.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/10/24 21:26
 */
@Repository
public interface UserDao extends BaseMapper<User> {
    User selectOneUserById(Integer id);

    int updateUserInfo(User user);

    int updatePhoto(Map<String, Object> map);

    List<UserStudyHistory> selectUserStudyHistory(String phoneNum);

    List<SchoolInfo> selectSchoolName();

    int applyTeacher(Teacher teacher);

    List<Professional> selectselectProfessionalName();

    int validPassword(User user);

    int updatePassword(User user);
}
