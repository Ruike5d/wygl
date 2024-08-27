package com.ityls.web.fee_park.entity;

import lombok.Data;

@Data
public class FeeParkParm {
    private Long currentPage;
    private Long pageSize;
    private String userName;
    private String parkName;
    private Long userId;

}
