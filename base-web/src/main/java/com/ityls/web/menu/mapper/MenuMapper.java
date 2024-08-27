package com.ityls.web.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ityls.web.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    // 根据物业人员的id查询权限
    List<Menu> getMenuByUserId(@Param("userId") Long userId);
    // 根据业主人员的id查询权限
    List<Menu> getMenuByUserIdForLiveUser(@Param("userId") Long userId);
    // 根据角色id查询原来的权限
    List<Menu> getMenuByRoleId(@Param("roleId") Long roleId);
}
