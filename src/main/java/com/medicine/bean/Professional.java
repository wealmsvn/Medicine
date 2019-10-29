package com.medicine.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("qc_professional")
public class Professional {
    @TableId(type = IdType.AUTO)
    int id;
    private String professionalName;
}
