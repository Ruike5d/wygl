package com.ityls.web.user_complaint.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ityls.web.park_list.entity.ParkListParm;
import com.ityls.web.user_complaint.entity.UserComplaint;
import com.ityls.web.user_complaint.entity.UserComplaintParm;

public interface UserComplaintService extends IService<UserComplaint> {
    IPage<UserComplaint> getList(UserComplaintParm userComplaintParm);
    IPage<UserComplaint> getMyList(UserComplaintParm userComplaintParm);
}
