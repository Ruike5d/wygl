package com.ityls.web.house_list.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("house_list")
public class HouseList implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long houseId;
    @TableField(exist = false)
    private Long buildId;
    private Long unitId;
    private String houseNum;
    @TableField(exist = false)
    private String name;
    private String unitName;
    private String houseArea;
    private String status;
}
