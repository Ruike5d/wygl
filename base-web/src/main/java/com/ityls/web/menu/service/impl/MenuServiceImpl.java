package com.ityls.web.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.menu.entity.Menu;
import com.ityls.web.menu.mapper.MenuMapper;
import com.ityls.web.menu.service.MenuService;
import com.ityls.web.menu.utils.MakeMenuTree;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<Menu> getParentList() {
        // 查询上级菜单只需要查询目录和菜单
        //目录>菜单>按钮
        String[] types = {"0","1"};
        //构造查询条件
        QueryWrapper<Menu> query = new QueryWrapper<>();
        query.lambda().in(Menu::getType, Arrays.asList(types)).orderByAsc(Menu::getOrderNum);
        List<Menu> menus = this.baseMapper.selectList(query);
        // 需要把menus处理成树形结构的数据
        Menu menu = new Menu();
        //L是长整形，不写也可以int类型会被自动转化为长整形
        //将所有菜单放在顶级菜单下,因为所有菜单的parentid是0，所以将顶级菜单id设置为0,他没有上级所以将parent设置为-1，最后拼接到menus集合中
        menu.setMenuId(0L);
        menu.setParentId(-1L);
        menu.setMenuLabel("顶级菜单");
        menus.add(menu);
        // todo..
        List<Menu> menuList = MakeMenuTree.makeTree(menus,-1L);

        return menuList;
    }

    @Override
    public List<Menu> getList() {
        //构造查询条件
        QueryWrapper<Menu> query = new QueryWrapper<>();
        query.lambda().orderByAsc(Menu::getOrderNum);
        List<Menu> menus= this.baseMapper.selectList(query);
        // 需要把menus处理成树形结构的数据
        // todo..
        List<Menu> menuList = MakeMenuTree.makeTree(menus,0L);
        return menuList;
    }

    @Override
    public List<Menu> getMenuByUserId(Long userId) {
        return this.baseMapper.getMenuByUserId(userId);
    }

    @Override
    public List<Menu> getMenuByUserIdForLiveUser(Long userId) {
        return this.baseMapper.getMenuByUserIdForLiveUser(userId);
    }

    @Override
    public List<Menu> getMenuByRoleId(Long roleId) {
        return this.baseMapper.getMenuByRoleId(roleId);
    }
}
