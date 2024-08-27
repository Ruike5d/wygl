package com.ityls.web.house_unit.entity;

import lombok.Data;

@Data
public class HouseUnitParm {
    private String buildName;
    private String unitName;

    private Long currentPage;
    private Long pageSize;
}
