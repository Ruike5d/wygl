package com.ityls.web.user_complaint.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ityls.web.park_list.entity.ParkListParm;
import com.ityls.web.user_complaint.entity.UserComplaint;
import com.ityls.web.user_complaint.entity.UserComplaintParm;
import com.ityls.web.user_complaint.mapper.UserComplaintMapper;
import com.ityls.web.user_complaint.service.UserComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserComplaintServiceImpl extends ServiceImpl<UserComplaintMapper, UserComplaint> implements UserComplaintService {

    @Override
    public IPage<UserComplaint> getList(UserComplaintParm userComplaintParm) {
        // 创建查询包装器，用于动态SQL查询
        LambdaQueryWrapper<UserComplaint> query = new LambdaQueryWrapper<>();
        // 根据标题进行模糊查询，并按创建时间降序排序
        query.like(UserComplaint::getTitle, userComplaintParm.getTitle()).like(UserComplaint::getComplaintContent, userComplaintParm.getComplaintContent());
        // 初始化分页对象
        Page<UserComplaint> page = new Page<>();
        // 设置当前页码和每页显示数量
        page.setCurrent(userComplaintParm.getCurrentPage());
        page.setSize(userComplaintParm.getPageSize());

        return this.baseMapper.selectPage(page,query);
    }

    @Override
    public IPage<UserComplaint> getMyList(UserComplaintParm userComplaintParm) {
        // 创建查询包装器，用于动态SQL查询
        LambdaQueryWrapper<UserComplaint> query = new LambdaQueryWrapper<>();
        // 根据标题进行模糊查询，并按创建时间降序排序
        query.like(UserComplaint::getTitle, userComplaintParm.getTitle()).like(UserComplaint::getComplaintContent, userComplaintParm.getComplaintContent())
                .eq(UserComplaint::getUserId,userComplaintParm.getUserId());
        // 初始化分页对象
        Page<UserComplaint> page = new Page<>();
        // 设置当前页码和每页显示数量
        page.setCurrent(userComplaintParm.getCurrentPage());
        page.setSize(userComplaintParm.getPageSize());

        return this.baseMapper.selectPage(page,query);
    }
}
