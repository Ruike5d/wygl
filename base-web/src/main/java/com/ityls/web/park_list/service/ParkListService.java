package com.ityls.web.park_list.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.park_list.entity.ParkList;
import com.ityls.web.park_list.entity.ParkListParm;

public interface ParkListService extends IService<ParkList> {
    IPage<ParkList> getList(ParkListParm parkListParm);
}
