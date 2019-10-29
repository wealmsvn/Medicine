package com.medicine.bean;

import lombok.Data;

import java.util.Date;

@Data
public class School {
    private String id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String identifier;

    private String name;

    private String logo;

    private Integer siteId;

    private String province;

    private String city;

}
