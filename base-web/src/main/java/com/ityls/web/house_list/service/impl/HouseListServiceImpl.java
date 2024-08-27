package com.ityls.web.house_list.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.house_list.entity.HouseList;
import com.ityls.web.house_list.entity.ListParm;
import com.ityls.web.house_list.mapper.HouseListMapper;
import com.ityls.web.house_list.service.HouseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseListServiceImpl extends ServiceImpl<HouseListMapper, HouseList> implements HouseListService {
    @Override
    public IPage<HouseList> getList(ListParm parm) {
        // 创建一个分页对象，用于查询房屋列表
        IPage<HouseList> page = new Page<>();
        // 设置当前页码，来自参数中的currentPage字段
        page.setCurrent(parm.getCurrentPage());
        // 设置每页显示的数量，来自参数中的pageSize字段
        page.setSize(parm.getPageSize());
        // 调用映射器的方法获取房屋列表，传入分页对象和查询参数，包括楼名、单元名、房间号和状态
        return this.baseMapper.getList(page,parm.getBuildName(),parm.getUnitName(),parm.getHouseNum(),parm.getStatus());
    }
}
