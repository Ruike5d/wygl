package com.ityls.web.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.user.entity.User;
import com.ityls.web.user.entity.UserParm;
import com.ityls.web.user_role.entity.UserRole;
import org.springframework.stereotype.Service;


public interface UserService extends IService<User> {
    //查询用户列表
    IPage<User> list(UserParm parm);
    //根据用户id查询角色
    UserRole getRoleByUserId(UserRole userRole);
    //保存用户角色
    void  saveRole(UserRole userRole);
    //根据登录名查用户信息
    User loadUser(String username);

}
