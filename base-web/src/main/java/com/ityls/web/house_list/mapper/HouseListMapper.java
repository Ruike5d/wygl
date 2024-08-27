package com.ityls.web.house_list.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ityls.web.house_list.entity.HouseList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * 配置param以便在动态sql中直接用参数名不用再使用arg0等
 * */

@Mapper
public interface HouseListMapper extends BaseMapper<HouseList> {
    IPage<HouseList> getList(IPage<HouseList> page,
                             @Param("buildName")String buildName,@Param("unitName")String unitName,
                             @Param("houseNum")String houseNum,@Param("status")String status);
}
