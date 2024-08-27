package com.ityls.web.fee_water.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.fee_power.entity.FeePowerParm;
import com.ityls.web.fee_water.entity.FeeWater;
import com.ityls.web.fee_water.entity.FeeWaterParm;

public interface FeeWaterService extends IService<FeeWater> {
    IPage<FeeWater> getList(FeeWaterParm feeWaterParm);
}
