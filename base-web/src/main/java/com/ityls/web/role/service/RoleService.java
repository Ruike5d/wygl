package com.ityls.web.role.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.role.entity.*;

public interface RoleService extends IService<Role> {
    //带条件的分页查询
    IPage<Role> list(RoleParm parm);
    //权限树的回显
    RolePermissionVo getAssignTree(RoleAssignParm parm);
    //保存权限
    void saveAssign(RolePermissionParm parm);
}
