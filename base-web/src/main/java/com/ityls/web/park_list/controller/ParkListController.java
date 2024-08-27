package com.ityls.web.park_list.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ityls.utils.ResultUtils;
import com.ityls.utils.ResultVo;
import com.ityls.web.park_list.entity.ParkList;
import com.ityls.web.park_list.entity.ParkListParm;
import com.ityls.web.park_list.service.impl.ParkListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/parkList")
public class ParkListController {
    @Autowired
    private ParkListServiceImpl parkListService;

    //带条件的分页查询
    @GetMapping("/list")
    public ResultVo getList(ParkListParm parm){
        //把逻辑写在Service中
        IPage<ParkList> list = parkListService.getList(parm);
         return ResultUtils.success("查询成功",list);
    }


    /**
     * 新增车位
     */
    @PostMapping
    public ResultVo add(@RequestBody ParkList parkList){
        boolean save = parkListService.save(parkList);
        if(save){
            return ResultUtils.success("新增车位成功!");
        }
        return ResultUtils.error("新增车位失败!");
    }

    /**
     * 编辑车位
     */
    @PutMapping
    public ResultVo edit(@RequestBody ParkList parkList){
        boolean save = parkListService.updateById(parkList);
        if(save){
            return ResultUtils.success("编辑车位成功!");
        }
        return ResultUtils.error("编辑车位失败!");
    }

    /**
     * 删除车位
     */
    @DeleteMapping("/{parkId}")
    public ResultVo delete(@PathVariable("parkId") Long parkId){
        boolean b = parkListService.removeById(parkId);
        if(b){
            return ResultUtils.success("删除车位成功!");
        }
        return ResultUtils.error("删除车位失败!");
    }

    /**
     * 查询所有车位
     */
    @GetMapping("/listNoPage")
    public ResultVo getListNoPage(){
        List<ParkList> list = parkListService.list();
        return ResultUtils.success("查询成功",list);
    }

}
