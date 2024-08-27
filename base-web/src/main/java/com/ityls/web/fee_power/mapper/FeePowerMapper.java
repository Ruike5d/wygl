package com.ityls.web.fee_power.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ityls.web.fee_power.entity.FeePower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FeePowerMapper extends BaseMapper<FeePower> {
    IPage<FeePower> getList(IPage<FeePower> page, @Param("username") String userName, @Param("houseNum") String houseNum);

}
