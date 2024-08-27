package com.ityls.web.user_complaint.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ityls.utils.ResultUtils;
import com.ityls.utils.ResultVo;
import com.ityls.web.sys_notice.entity.SysNotice;
import com.ityls.web.sys_notice.entity.SysNoticeParm;
import com.ityls.web.user_complaint.entity.UserComplaint;
import com.ityls.web.user_complaint.entity.UserComplaintParm;
import com.ityls.web.user_complaint.service.UserComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/userComplaint")
public class UserComplaintController {
    @Autowired
    private UserComplaintService userComplaintService;

    /**
     * 投诉列表
     * @param userComplaintParm
     * @return
     */
    @GetMapping("/list")
    public ResultVo getList(UserComplaintParm userComplaintParm) {
        // 执行分页查询
        IPage<UserComplaint> list = userComplaintService.getList(userComplaintParm);
        // 返回成功结果，包含查询结果
        return ResultUtils.success("查询成功", list);
    }

    /**
     * 我的投诉
     */
    @GetMapping("/myList")
    public ResultVo getMyList(UserComplaintParm userComplaintParm) {
        // 执行分页查询
        IPage<UserComplaint> list = userComplaintService.getMyList(userComplaintParm);
        // 返回成功结果，包含查询结果
        return ResultUtils.success("查询成功", list);
    }

    /**
     * 新增投诉
     */
    @PostMapping()
    public ResultVo add(@RequestBody UserComplaint userComplaint) {
        //设置投诉状态
        userComplaint.setStatus("0");
        //设置投诉时间
        userComplaint.setCreateTime(new Date());
        //入库保存
        boolean save = userComplaintService.save(userComplaint);
        if(save){
            return ResultUtils.success("投诉成功!");
        }
        return ResultUtils.error("投诉失败!");
    }


    /**
     * 编辑投诉
     */
    @PutMapping
    public ResultVo edit(@RequestBody UserComplaint userComplaint){
        //编辑保存
        boolean save = userComplaintService.updateById(userComplaint);
        if(save){
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败!");
    }


    /**
     * 删除
     * @param complaintId
     * @return
     */
    @DeleteMapping("/{complaintId}")
    public ResultVo delete(@PathVariable("complaintId") Long complaintId){
        boolean save = userComplaintService.removeById(complaintId);
        if(save){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");


    }

}