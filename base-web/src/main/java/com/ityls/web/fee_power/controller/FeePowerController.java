package com.ityls.web.fee_power.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ityls.utils.ResultUtils;
import com.ityls.utils.ResultVo;
import com.ityls.web.fee_power.entity.FeePower;
import com.ityls.web.fee_power.entity.FeePowerParm;
import com.ityls.web.fee_power.service.impl.FeePowerServiceImpl;
import com.ityls.web.live_house.entity.LiveHouse;
import com.ityls.web.live_house.service.impl.LiveHouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 电费管理控制器
 */
@RestController
@RequestMapping("api/feePower")
public class FeePowerController {

    @Autowired
    private FeePowerServiceImpl feePowerService;

    @Autowired
    public LiveHouseServiceImpl liveHouseService;

    /**
     * 列表查询
     */
    @GetMapping("/list")
    public ResultVo getList(FeePowerParm feePowerParm){
        IPage<FeePower> list = feePowerService.getList(feePowerParm);
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 新增电费
     */
    @PostMapping
    public ResultVo add(@RequestBody FeePower feePower){
        LambdaQueryWrapper<LiveHouse> query = new LambdaQueryWrapper<>();
        query.eq(LiveHouse::getHouseId, feePower.getHouseId()).eq(LiveHouse::getUseStatus, "0");
        LiveHouse house = liveHouseService.getOne(query);
        if(house == null){
            //没有人使用这个房间
            return ResultUtils.error("该房间没有人使用,不能添加电费");

        }
        feePower.setUserId(house.getUserId());
        feePowerService.saveFeePower(feePower);
        return ResultUtils.success("新增电费成功");
    }

    /**
     * 编辑电费
     */

    @PutMapping
    public ResultVo edit(@RequestBody FeePower feePower){
        LambdaQueryWrapper<LiveHouse> query = new LambdaQueryWrapper<>();
        query.eq(LiveHouse::getHouseId, feePower.getHouseId()).eq(LiveHouse::getUseStatus, "0");
        LiveHouse house = liveHouseService.getOne(query);
        if(house == null){
            //没有人使用这个房间
            return ResultUtils.error("该房间没有人使用,不能添加电费");

        }
        feePower.setUserId(house.getUserId());
        feePowerService.updateFeePower(feePower);
        return ResultUtils.success("编辑电费成功");
    }

    /**
     * 删除电费
     */
    @DeleteMapping("/{powerId}")
    public ResultVo delete(@PathVariable("powerId") Long powerId){
        LambdaQueryWrapper<FeePower> query = new LambdaQueryWrapper<>();
        query.eq(FeePower::getPowerId,powerId).eq(FeePower::getPayPowerStatus, "1");
        FeePower one = feePowerService.getOne(query);
        if(one != null){
            //没有人使用这个房间
            return ResultUtils.error("已缴费，不能删除");

        }
        boolean b = feePowerService.removeById(powerId);
        if (b){
            return ResultUtils.success("删除电费成功");
        }
        return ResultUtils.error("删除电费失败");
    }

    /**
     * 缴费
     */
    @PostMapping("/payPower")
    public ResultVo payPower(@RequestBody FeePower feePower){
        boolean b = feePowerService.updateById(feePower);
        if (b){
            return ResultUtils.success("缴费成功");
        }
            return ResultUtils.error("缴费失败");
    }

    /**
     * 我的电费
     */

    @GetMapping("/getMyPowerFee")
    public ResultVo getMyPowerFee( FeePowerParm feePowerParm){
        //构造分页条件
        IPage<FeePower> page = new Page<>();
        page.setCurrent(feePowerParm.getCurrentPage());
        page.setSize(feePowerParm.getPageSize());

        //查询条件
        LambdaQueryWrapper<FeePower> query = new LambdaQueryWrapper<>();
        query.eq(FeePower::getUserId,feePowerParm.getUserId());
        IPage<FeePower> list = feePowerService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }

}
