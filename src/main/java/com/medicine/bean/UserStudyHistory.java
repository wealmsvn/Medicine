package com.medicine.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_study_history")
public class UserStudyHistory {
@TableId(type = IdType.AUTO)
    private int id;
    private Date studyTime;
    private String studyTitle;
    private String studySummary;
    private int uid;
}
