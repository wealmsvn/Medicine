package com.medicine.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String id;

    private String createBy;

    private Date createDate;

    private String name;

    private String isbn;

    private String publish;

    private Date publishDate;

    private String price;

    private String author;

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
