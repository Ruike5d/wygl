package com.ityls.web.house_building.entity;

import lombok.Data;

@Data
public class HouseBuildingParm {
    private String name;
    private String type;

    private Long currentPage;
    private Long pageSize;
}
