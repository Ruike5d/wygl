package com.ityls.web.fee_power.entity;

import lombok.Data;

@Data
public class FeePowerParm {
    private Long currentPage;
    private Long pageSize;
    private String userName;
    private String houseNum;
    private  Long userId;
}
