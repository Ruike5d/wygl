package com.ityls.web.house_building.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ityls.utils.ResultUtils;
import com.ityls.utils.ResultVo;
import com.ityls.web.house_building.entity.HouseBuilding;
import com.ityls.web.house_building.entity.HouseBuildingParm;
import com.ityls.web.house_building.service.HouseBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HouseBuilding")
public class HouseBuildingController {

    @Autowired
    private HouseBuildingService houseBuildingService;
    // 分页查询(带条件的分页)
    @GetMapping("/list")
    public ResultVo getList(HouseBuildingParm parm){
        IPage<HouseBuilding> list = houseBuildingService.getList(parm);
        return ResultUtils.success("查询成功",list);
    }

    // 在新增单元时，查询出所有的栋
    @GetMapping("/unitList")
    public ResultVo unitList(){
        List<HouseBuilding> list = houseBuildingService.list();
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 删除栋数
     * @param buildId
     * @return
     */
    @DeleteMapping("/{buildId}")
    public ResultVo delete(@PathVariable("buildId") Long buildId){
        boolean b = houseBuildingService.removeById(buildId);
        if(b){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }


    @PostMapping
    public ResultVo add(@RequestBody HouseBuilding houseBuilding){
        boolean save = houseBuildingService.save(houseBuilding);
        if(save){
            return ResultUtils.success("新增成功!");
        }
        return ResultUtils.error("新增失败!");
    }

    @PutMapping
    public ResultVo edit(@RequestBody HouseBuilding houseBuilding){
        boolean b = houseBuildingService.updateById(houseBuilding);
        if(b){
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败!");
    }

}
