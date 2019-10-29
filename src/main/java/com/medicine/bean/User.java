package com.medicine.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("qc_user")
public class User {
    @TableId(type = IdType.AUTO)
    private String id;

    private Date createDate;

    private String loginName;

    private String password;

    private String name;

    private String mobile;

    private Integer mobileAuth;

    private String photo;

    private String loginIp;

    private Date loginTime;

    private Integer loginCount;

    private String lastLoginIp;

    private Date lastLoginTime;

    private String remarks;

    private Integer userType;

    private String schoolId;

    private String nickname;

    private Integer sex;

    private Date birthday;

    private String occupation;

    private String introduction;

    private String wechatOpenid;


}