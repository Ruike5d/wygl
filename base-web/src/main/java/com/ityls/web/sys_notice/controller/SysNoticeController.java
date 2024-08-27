package com.ityls.web.sys_notice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ityls.utils.ResultUtils;
import com.ityls.utils.ResultVo;
import com.ityls.web.sys_notice.entity.SysNotice;
import com.ityls.web.sys_notice.entity.SysNoticeParm;
import com.ityls.web.sys_notice.service.SysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/sysNotice")
public class SysNoticeController {
    @Autowired
    private SysNoticeService sysNoticeService;

    // 分页查询(带条件的分页)
    /**
     * 获取通知列表
     * 该方法通过接收SysNoticeParm参数来查询系统通知
     * 它使用了分页和筛选功能，以提供更灵活的查询方式
     *
     * @param parm 查询参数，包括页码、每页大小和标题关键词
     * @return 返回一个ResultVo对象，包含查询结果和提示信息
     */
    @GetMapping("/list")
    public ResultVo getList(SysNoticeParm parm){
        // 创建查询包装器，用于动态SQL查询
        QueryWrapper<SysNotice> query = new QueryWrapper<>();
        // 根据标题进行模糊查询，并按创建时间降序排序
        query.like("title",parm.getTitle()).orderByDesc("create_time");

        // 初始化分页对象
        Page<SysNotice> page = new Page<SysNotice>();
        // 设置当前页码和每页显示数量
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getPageSize());
        // 执行分页查询
        Page<SysNotice> list = sysNoticeService.page(page, query);
        // 返回成功结果，包含查询结果
        return ResultUtils.success("查询成功",list);
    }

    /**
     * 通过ID删除通知
     *
     * @param noticeId 通知的唯一ID
     * @return 删除操作的结果
     *         - 如果删除成功，返回成功结果，附带消息"删除成功"
     *         - 如果删除失败，返回错误结果，附带消息"删除失败"
     */
    @DeleteMapping("/{noticeId}")
    public ResultVo delete(@PathVariable("noticeId") Long noticeId){
        // 调用服务层的删除方法，根据ID删除通知
        boolean b = sysNoticeService.removeById(noticeId);
        // 根据删除结果返回相应的提示信息
        if(b){
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.error("删除失败");
    }

    /**
     * 新增通知公告
     *
     * @param sysNotice 待新增的公告信息，使用RequestBody注解接收前端传入的JSON数据
     * @return 返回结果对象，包含状态码和消息，用于前端展示
     */
    @PostMapping
    public ResultVo add(@RequestBody SysNotice sysNotice){
        // 设置公告的创建时间为当前时间，确保时间的准确性
        sysNotice.setCreateTime(new Date());

        // 尝试保存公告信息，返回保存结果
        boolean b = sysNoticeService.save(sysNotice);

        // 根据保存结果返回相应提示信息
        if(b){
            return ResultUtils.success("新增成功");
        }
        return ResultUtils.error("新增失败");
    }

    @PutMapping
    public ResultVo edit(@RequestBody SysNotice sysNotice){
        sysNotice.setCreateTime(new Date());
        boolean b = sysNoticeService.updateById(sysNotice);
        if(b){
            return ResultUtils.success("编辑成功");
        }
        return ResultUtils.error("编辑失败");
    }

}
