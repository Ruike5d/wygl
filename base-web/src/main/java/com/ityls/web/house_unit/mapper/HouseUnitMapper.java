package com.ityls.web.house_unit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ityls.web.house_unit.entity.HouseUnit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HouseUnitMapper extends BaseMapper<HouseUnit> {
    IPage<HouseUnit> getList(IPage<HouseUnit> page, @Param("unitName") String unitName,@Param("buildName") String buildName);
}
