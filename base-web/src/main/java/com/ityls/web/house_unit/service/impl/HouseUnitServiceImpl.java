package com.ityls.web.house_unit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.house_unit.entity.HouseUnit;
import com.ityls.web.house_unit.entity.HouseUnitParm;
import com.ityls.web.house_unit.mapper.HouseUnitMapper;
import com.ityls.web.house_unit.service.HouseUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseUnitServiceImpl extends ServiceImpl<HouseUnitMapper, HouseUnit> implements HouseUnitService {

    @Autowired
    private HouseUnitMapper houseUnitMapper;

    @Override
    public IPage<HouseUnit> getList(HouseUnitParm houseUnitParm) {
        IPage<HouseUnit> page = new Page<>();
        page.setSize(houseUnitParm.getPageSize());
        page.setCurrent(houseUnitParm.getCurrentPage());
        IPage<HouseUnit> list = houseUnitMapper.getList(page, houseUnitParm.getUnitName(), houseUnitParm.getBuildName());
        return list;
    }
}
