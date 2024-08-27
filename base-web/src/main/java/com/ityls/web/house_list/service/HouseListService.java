package com.ityls.web.house_list.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.house_list.entity.HouseList;
import com.ityls.web.house_list.entity.ListParm;

import java.util.List;

public interface HouseListService extends IService<HouseList> {
    IPage<HouseList> getList(ListParm parm);
}
