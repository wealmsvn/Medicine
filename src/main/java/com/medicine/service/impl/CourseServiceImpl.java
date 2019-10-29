package com.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medicine.bean.Course;
import com.medicine.dao.CourseDao;
import com.medicine.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course> implements CourseService {

    @Override
    public List<Course> queryCourse(Integer levelId) {
        List<Course> courseList = null;

        if(levelId != null && levelId !=0){

             courseList = getBaseMapper().selectCourse(levelId);

        }else{
            courseList = getBaseMapper().selectAllCourse();
        }
        return courseList;
    }
}
