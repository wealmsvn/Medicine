package com.medicine.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("qc_school")
@Data
public class SchoolInfo {
    @TableId(type = IdType.AUTO)
    private String id;
    private String identifier;
    private String name;
}
