package com.ityls.web.role.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleAssignParm implements Serializable {
    //根据用户id分配角色
    //用户id
    private  Long userId;
    //角色id
    private  Long roleId;

 }
