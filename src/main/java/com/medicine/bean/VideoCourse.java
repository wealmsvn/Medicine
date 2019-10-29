package com.medicine.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("qc_books")
public class VideoCourse {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String publish;
    private int channelId = 2;
}
