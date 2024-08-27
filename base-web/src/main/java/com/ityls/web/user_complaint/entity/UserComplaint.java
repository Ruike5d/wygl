package com.ityls.web.user_complaint.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_complaint")
public class UserComplaint {
    @TableId(type = IdType.AUTO)
    private Long complaintId;
    private Long userId;
    private String title;
    private String complaintContent;
    private Date createTime;
    private String status;

}
