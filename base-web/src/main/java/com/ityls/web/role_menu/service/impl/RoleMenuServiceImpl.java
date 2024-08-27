package com.ityls.web.role_menu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.role_menu.entity.RoleMenu;
import com.ityls.web.role_menu.mapper.RoleMenuMapper;
import com.ityls.web.role_menu.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>implements RoleMenuService {


    @Override
    @Transactional
    public void saveRoleMenu(Long roleId, List<Long> menuIds) {
        LambdaQueryWrapper<RoleMenu> query = new LambdaQueryWrapper<RoleMenu>();
        query.eq(RoleMenu::getMenuId, roleId);
        this.baseMapper.delete(query);
        //保存新权限
        this.baseMapper.saveRoleMenu(roleId, menuIds);
    }
}
