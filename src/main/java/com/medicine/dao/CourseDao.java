package com.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medicine.bean.Course;

import java.util.List;

public interface CourseDao extends BaseMapper<Course> {
    List<Course> selectAllCourse();

    List<Course> selectCourse(Integer levelId);
}
