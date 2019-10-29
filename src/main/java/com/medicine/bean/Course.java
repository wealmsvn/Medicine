package com.medicine.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("qc_teachers")
@Data
public class Course  {

    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String collegeId;
    private String course;
    private String courseDes;
    private String courseImg;
    private String identifier;


}
