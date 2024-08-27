package com.ityls.web.house_unit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.house_unit.entity.HouseUnit;
import com.ityls.web.house_unit.entity.HouseUnitParm;

public interface HouseUnitService extends IService<HouseUnit> {
    IPage<HouseUnit> getList(HouseUnitParm parm);

}
