package com.medicine.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("qc_teacher")
public class Teacher {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String collegeId;
    private String department;
    private String idCard;
    private String professionalId;
    private String course;
    private String teacherCardId;

    private String userId;
}
