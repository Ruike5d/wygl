package com.ityls.web.fee_park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ityls.web.fee_park.entity.FeePark;
import org.apache.ibatis.annotations.Param;

public interface FeeParkMapper extends BaseMapper<FeePark> {
    IPage<FeePark> getList(IPage<FeePark> page, @Param("userName") String userName, @Param("parkName")String parkName);
}
