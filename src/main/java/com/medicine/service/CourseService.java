package com.medicine.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.medicine.bean.Course;

import java.util.List;

public interface CourseService extends IService<Course> {

    List<Course> queryCourse(Integer levelId);
}
