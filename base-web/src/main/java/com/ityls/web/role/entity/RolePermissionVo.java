package com.ityls.web.role.entity;

import com.ityls.web.menu.entity.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class RolePermissionVo {
    //当前登录系统用户的菜单数据
    List<Menu> listmenu = new ArrayList<>();

    //角色原来分配的菜单
    private Objects[] checkList;
}
