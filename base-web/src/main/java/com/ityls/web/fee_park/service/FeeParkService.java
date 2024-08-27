package com.ityls.web.fee_park.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.fee_park.entity.FeePark;
import com.ityls.web.fee_park.entity.FeeParkParm;
import com.ityls.web.fee_water.entity.FeeWaterParm;

public interface FeeParkService extends IService<FeePark> {
    IPage<FeePark> getList(FeeParkParm parkParm);
}
