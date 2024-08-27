package com.ityls.web.fee_power.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.fee_power.entity.FeePower;
import com.ityls.web.fee_power.entity.FeePowerParm;

public interface FeePowerService extends IService<FeePower> {
    //数据来自五张表
    IPage<FeePower> getList(FeePowerParm feePowerParm);

    //新增电费
    void saveFeePower(FeePower feePower);

    //修改电费
    void updateFeePower(FeePower feePower);
}
