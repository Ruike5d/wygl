package com.ityls.web.park_list.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.park_list.entity.ParkList;
import com.ityls.web.park_list.entity.ParkListParm;
import com.ityls.web.park_list.mapper.ParkListMapper;
import com.ityls.web.park_list.service.ParkListService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ParkListServiceImpl extends ServiceImpl<ParkListMapper, ParkList> implements ParkListService {

    @Override
    public IPage<ParkList> getList(ParkListParm parkListParm) {
        LambdaQueryWrapper<ParkList> query = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(parkListParm.getParkName())){
            query.like(ParkList::getParkStatus, parkListParm.getParkName());
        }
        if (StringUtils.isNotEmpty(parkListParm.getParkStatus())){
            query.eq(ParkList::getParkStatus, parkListParm.getParkStatus());
        }
        if (StringUtils.isNotEmpty(parkListParm.getParkType())){
            query.eq(ParkList::getParkType, parkListParm.getParkType());
        }
        //构建分页条件
        IPage<ParkList> page = new Page<>();
        page.setCurrent(parkListParm.getCurrentPage());
        page.setSize(parkListParm.getPageSize());
        return this.baseMapper.selectPage(page, query);
    }
}
