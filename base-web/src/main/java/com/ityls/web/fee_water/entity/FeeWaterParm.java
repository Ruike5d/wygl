package com.ityls.web.fee_water.entity;

import lombok.Data;

@Data
public class FeeWaterParm {
    private Long currentPage;
    private Long pageSize;
    private String userName;
    private String houseNum;
    private Long userId;
}
