package com.ityls.web.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.menu.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService extends IService<Menu> {
    //上级菜单查询
    List<Menu> getParentList();
    //查询菜单列表
    List<Menu> getList();
    //-------------------------------------------------
    // 根据物业人员的id查询权限
    List<Menu> getMenuByUserId( Long userId);
    // 根据业主人员的id查询权限
    List<Menu> getMenuByUserIdForLiveUser( Long userId);
    // 根据角色id查询原来的权限
    List<Menu> getMenuByRoleId( Long roleId);
}
