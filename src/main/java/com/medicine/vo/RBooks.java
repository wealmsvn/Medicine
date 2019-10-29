package com.medicine.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("qc_books")
public class RBooks {
    @TableId(type = IdType.AUTO)
    private int id;
    private int bookTypeId;
    private int levelId;
    private String name;
    private String bookDes;
    private String coverImg;
    private String author;

}
