package com.ityls.web.user_repair.entity;

import lombok.Data;

@Data
public class UserRepairParm {
    private Long currentPage;
    private Long pageSize;
    private Long userId;
    private String repairContent;
}
