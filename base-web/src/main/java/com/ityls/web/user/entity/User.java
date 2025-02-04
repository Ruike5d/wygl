package com.ityls.web.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data  //自动生成get 和 set方法
@TableName("sys_user")  //指明User对应的数据库表是 sys_user表
public class User {

    //设置主键自增
    @TableId(type= IdType.AUTO)
    private Long userId;
    //姓名
    private String loginName;
    //登录密码
    private String password;
    //登录账号
    private String username;
    //电话
    private String phone;
    //性别 0：女 1：男
    private String sex;
    //身份证
    private String idCard;
    //是否是管理员 0：不是 1：是
    private String isAdmin;
    //0：在职  1：离职
    private String status;
    //0：启用 1：禁用
    private String isUsed;

}
