package com.ityls.web.menu.utils;

import com.ityls.web.menu.entity.Menu;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MakeMenuTree {
    public static List<Menu> makeTree(List<Menu> menuList, Long pid){
        //存放的是组装之后的树
        List<Menu> list = new ArrayList<>();
        //组装树数据
        Optional.ofNullable(menuList).orElse(new ArrayList<>())
                .stream()
                .filter(item -> item != null && item.getParentId() == pid)
                .forEach(dom ->{  //目的就是查找每一条数据的下级
                    Menu menu = new Menu();
                    //把过滤出来的数据放到新的menu里面
                    BeanUtils.copyProperties(dom,menu);
                    //找出当前数据的下级
                    List<Menu> children = makeTree(menuList, dom.getMenuId());
                    menu.setChildren(children);
                    list.add(menu);
                });
        return list;
    }
}
