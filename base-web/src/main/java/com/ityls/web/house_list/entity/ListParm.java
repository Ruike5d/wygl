package com.ityls.web.house_list.entity;

import lombok.Data;

@Data
public class ListParm {
    //栋数名称
    private  String buildName;
    private  String status;
    //单元名称
    private  String unitName;
    private  String houseNum;
    private  Long currentPage;
    private Long pageSize;
}
