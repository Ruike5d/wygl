package com.ityls.web.house_building.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.house_building.entity.HouseBuilding;
import com.ityls.web.house_building.entity.HouseBuildingParm;
import com.ityls.web.house_building.mapper.HouseBuildingMapper;
import com.ityls.web.house_building.service.HouseBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseBuildingServiceImpl extends ServiceImpl<HouseBuildingMapper, HouseBuilding> implements HouseBuildingService {

    @Autowired
    private HouseBuildingMapper houseBuildingMapper;
    @Override
    public IPage<HouseBuilding> getList(HouseBuildingParm parm) {
        QueryWrapper<HouseBuilding> query = new QueryWrapper<>();
        query.like("name", parm.getName())
                .like("type", parm.getType());

        Page<HouseBuilding> page = new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getPageSize());

        return  houseBuildingMapper.selectPage(page, query);
    }
}
