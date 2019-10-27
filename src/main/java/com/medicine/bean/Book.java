package com.medicine.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

@Data
@Api(tags = "书籍类信息")
@TableName("qc_books")
public class Book {
    @TableId(type = IdType.AUTO)
    private int id;


    private int bookTypeId;
    private int levelId;
    @ApiParam(value = "创建者")
    private String createBy;

    @ApiParam(value = "创建日期")
    private Date createDate;

    @ApiParam(value = "教材名称")
    private String name;

    private String bookDes;
    @ApiParam(value = "Isbn")
    private String isbn;

    @ApiParam(value = "出版社")
    private String publish;

    @ApiParam(value = "出版时间")
    private Date publishDate;

    @ApiParam(value = "纸书定价")
    private String price;

    @ApiParam(value = "作者")
    private String author;

    @ApiParam(value = "封面图片")
    private String coverImg;

    private Integer shelvesStatus;

    private Integer openStatus;

    private Integer channelId;

    private String qcKnowledgeId;

    private String qcKnowledgeName;

    private Integer siteId;

    private String updateBy;

    private Date updateDate;

    private String seriesTitle;

    private String bookSize;

    private Integer kWords;

    private String epub;

}
