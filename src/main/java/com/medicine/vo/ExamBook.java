package com.medicine.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("cms_content")
@Data
public class ExamBook {
    @TableId(type = IdType.AUTO)
    private int id;
    private String title;
    private String author;
    private int flag;
    private  String titleImg;
}
