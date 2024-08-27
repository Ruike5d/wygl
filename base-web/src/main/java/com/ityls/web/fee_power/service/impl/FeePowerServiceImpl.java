package com.ityls.web.fee_power.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.fee_power.entity.FeePower;
import com.ityls.web.fee_power.entity.FeePowerParm;
import com.ityls.web.fee_power.mapper.FeePowerMapper;
import com.ityls.web.fee_power.service.FeePowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeePowerServiceImpl extends ServiceImpl<FeePowerMapper, FeePower> implements FeePowerService {
    @Autowired
    private FeePowerMapper feePowerMapper;

    @Override
    public IPage<FeePower> getList(FeePowerParm feePowerParm) {
        //这里就不用query的模糊查询了
        IPage<FeePower> page = new Page<>();
        page.setCurrent(feePowerParm.getCurrentPage());
        page.setSize(feePowerParm.getPageSize());
        return this.baseMapper.getList(page, feePowerParm.getUserName(), feePowerParm.getHouseNum());
    }

    @Override
    public void saveFeePower(FeePower feePower) {
        feePowerMapper.insert(feePower);
    }

    @Override
    public void updateFeePower(FeePower feePower) {
        feePowerMapper.updateById(feePower);
    }
}
