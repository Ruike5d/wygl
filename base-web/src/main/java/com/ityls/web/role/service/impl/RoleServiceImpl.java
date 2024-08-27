package com.ityls.web.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.role.entity.*;
import com.ityls.web.role.mapper.RoleMapper;
import com.ityls.web.role.service.RoleService;
import com.ityls.web.role_menu.service.RoleMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>implements RoleService {

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public IPage<Role> list(RoleParm parm) {
        //构造查询条件
        LambdaQueryWrapper<Role> query = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(parm.getRoleName())){
            query.like(Role::getRoleName, parm.getRoleName());
        }
        //构造分页条件
        IPage<Role> page = new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getPageSize());
        return this.baseMapper.selectPage(page, query);
    }

    // 权限树的回显,需要查询当前用户信息, 如果是超级管理员,拥有全部权限
    // 如果不是超级管理员,需要根据用户id查询,还需要拼装成一个树形结构
    // 还需要查询此用户对应的角色原来的权限
    @Override
    public RolePermissionVo getAssignTree(RoleAssignParm parm) {
        return null;
    }

    @Override
    public void saveAssign(RolePermissionParm parm) {
        roleMenuService.saveRoleMenu(parm.getRoleId(), parm.getList());
    }
}
