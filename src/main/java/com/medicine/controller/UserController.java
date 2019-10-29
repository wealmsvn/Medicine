package com.medicine.controller;


import com.alibaba.druid.util.StringUtils;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.medicine.bean.*;

import com.medicine.service.UserService;
import com.medicine.utils.InfoUtils;
import com.medicine.utils.JsonUtils;
import com.medicine.utils.SmsUtils;
import com.medicine.utils.UUIDUtils;
import com.medicine.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;

import java.io.File;
import java.util.List;

import static com.medicine.utils.SmsUtils.sendSms;


@RestController
//@Api(value = "用户增删改查等操作", tags = "用户的增删改查等操作")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    JedisPool jedisPool;

    @GetMapping("/user/showMyInfo")
    @ApiOperation(value = "展示用户学习记录", tags = "展示用户学习记录")
    public Result myInfo(String mobile) {
        Jedis jedis = jedisPool.getResource();
        String phoneNum = jedis.get(mobile);
        List<UserStudyHistory> studyHistoryList = userService.selectUserStudyHistory(phoneNum);
        return Result.success(studyHistoryList);
    }

    @GetMapping("/user/selectSchoolName")
    @ApiOperation(value = "得到学校信息", tags = "所有学校信息")
    public Result selectSchoolName() {
        Jedis jedis = jedisPool.getResource();
        if (jedis.exists("school")) {
            return Result.success(jedis.get("school"));
        } else {
            List<SchoolInfo> schoolInfoList = userService.selectSchoolName();
            if (schoolInfoList != null) {
                String schoolToJson = JsonUtils.objectToJson(schoolInfoList);
                jedis.set("school", schoolToJson);
                return Result.success(jedis.get("school"));
            } else {
                return Result.error("获取学校信息失败");
            }
        }
    }

    @GetMapping("/user/selectProfessionalName")
    @ApiOperation(value = "得到所有的职称", tags = "所有职称")
    public Result selectProfessionalName() {
        Jedis jedis = jedisPool.getResource();
        if (jedis.exists("professional")) {
            return Result.success(jedis.get("professional"));
        } else {
            List<Professional> professionalList = userService.selectselectProfessionalName();
            if (professionalList != null) {
                String s = JsonUtils.objectToJson(professionalList);
                jedis.set("professional", s);
                return Result.success(jedis.get("professional"));
            } else {
                return Result.error("获取失败");
            }
        }
    }

    @PostMapping("/user/applyTeacher")
    @ApiOperation(value = "申请成为教师", tags = "申请成为教师")
    public Result applyTeacher(Teacher teacher) {

        int result = userService.applyTeacher(teacher);
        return result > 0 ? Result.success("申请已提交，等待审核") : Result.error("提交失败");
    }

    @GetMapping("/user/showUserById")
    @ApiOperation(value = "根据用户的Id获取用户信息", tags = "根据用户的Id获取用户信息")
    public Result<User> showUserById(Integer id) {

        User user = userService.selectOneUserById(id);

        return Result.success(user);
    }

    @ApiOperation(value = "更改用户信息", tags = "更改用户信息")
    @PutMapping("/user/updateUser")
    public Result updateUserInfo(User user) {
        int result = userService.updateUserInfo(user);
        return result > 0 ? Result.success("更改成功") : Result.error(null);

    }

    @ApiOperation(value = "上传头像", tags = "上传头像")
    @PutMapping("/user/uploadHeadImg")
    public Result uploadHeadImg(MultipartFile headImg, Integer id) {

        String oldName = headImg.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //截取后缀名
        String newName = UUIDUtils.getUUID() + suffix;
        int result = userService.updatePhoto(newName, id);
        try {
            //把新图片添加到IMG_PATH中，图片服务器
            headImg.transferTo(new File(InfoUtils.getProperties("IMG_PATH"), newName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imgUrl = InfoUtils.getProperties("IMG_URL") + newName;
        System.out.println(imgUrl);
        return Result.success(imgUrl);
    }

    @GetMapping("/user/creatSmCode")
    @ApiOperation(value = "生成手机验证码", notes = "生成手机验证码")
    public Result creatSmCode(String mobile) throws ClientException {
        Jedis jedis = jedisPool.getResource();
        //生成验证码
        SmsUtils.setNewcode();
        String newcode = Integer.toString(SmsUtils.getNewcode());
        if (newcode != null) {
            //发送该码给指定的手机号
            SendSmsResponse response = sendSms(mobile, newcode);

            jedis.set("SmsCode", newcode);
            jedis.expire("SmsCode", 60);
            return Result.success("发送成功");
        } else {
            return Result.error("发送失败");
        }

    }

    @PutMapping("/user/validCode")
    @ApiOperation(value = "验证码验证", tags = "验证码验证")
    public Result validCode(String code) {
        Jedis jedis = jedisPool.getResource();

        if (jedis.exists("SmsCode")) {
            String code1 = jedis.get("SmsCode");
            if (StringUtils.equals(code, code1)) {
                return Result.success("验证码正确，可以修改");
            } else {
                return Result.error("验证码输入错误！");
            }
        } else {
            return Result.error("验证码已失效，请重新发送");
        }
    }

    @GetMapping("/user/validMobile")
    @ApiOperation(value = "验证新输入手机号是否跟之前重复", notes = "验证新输入手机号是否跟之前重复")
    public Result validMobile(String mobile, String oldMobile) {
        Jedis jedis = jedisPool.getResource();
        if (!StringUtils.equals(jedis.get("oldMobile"), mobile)) {
            return Result.success("可以修改");
        } else {
            return Result.error("手机号重复，请换个手机号！");
        }
    }

    @PutMapping("/user/updateMobile")
    @ApiOperation(value = "修改手机号", notes = "修改手机号")
    public Result updateMobile(String mobile) {
        //这里传入的手机号是新输入的手机号
        Jedis jedis = jedisPool.getResource();
        jedis.set(mobile, mobile);
        //这里仅仅改了redis内存里的手机号，需要通过消息中间键，修改数据库的信息；
        return Result.success(mobile);
    }

    //修改密码.前面步骤和修改手机号相似，都是通过手机号验证码通过之后到修改密码的界面，这里需要输入
    //原密码和新密码，然后再修改
    @GetMapping("/user/validPassword")
    @ApiOperation(value = "校验老密码是否正确", notes = "校验老密码是否正确")
    public Result validPassword(String passowrd, String mobile) {

        User user = new User();
        user.setMobile(mobile);
        user.setPassword(passowrd);

        int result = userService.validPassword(user);
        if (result > 0) {
            //如果大于0,证明老密码正确，因为我们一般新密码都不能和老密码一样，所以我们下一步要进行
            //老密码和新密码对比，所以我们暂时把老密码保存在redis中，以便于下一步的比较
            Jedis jedis = jedisPool.getResource();
            jedis.set("OldPassword", passowrd);
            jedis.expire("OldPassword", 300);

            return Result.success("原密码输入员正确!");

        }
        return Result.error("原密码输入错误，请重新输入！");
    }

    @GetMapping("/user/validNewPassword")
    @ApiOperation(value = "检验密码是否一致", notes = "检验密码是否一致")
    public Result validNewPassword(String newPassword) {
        Jedis jedis = jedisPool.getResource();

        if (jedis.exists("OldPassword")) {
            String oldPassword = jedis.get("OldPassword");
            if (!StringUtils.equals(newPassword, oldPassword)) {
                return Result.success("新密码符合!");
            } else {
                return Result.error("新密码不能和原密码一致");
            }
        } else {
            return Result.error("原密码登录已超时，请重新输入原密码！");
        }
    }

    @PutMapping("/user/updatePassword")
    @ApiOperation(value = "修改密码", notes = "修改密码")
    public Result updatePassword(String newPassword, String mobile) {
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(newPassword);
        int result = userService.updatePassword(user);
        return result > 0 ? Result.success("修改成功！") : Result.error("失败！");
    }


}
