package com.ityls.web.user_complaint.entity;

import lombok.Data;

@Data
public class UserComplaintParm {
    private Long currentPage;
    private Long pageSize;
    private String title;
    private String complaintContent;
    private Long userId;
}
