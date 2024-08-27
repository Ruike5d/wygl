package com.ityls.web.live_park.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 租户和车位关系表
 */
@Data
@TableName("live_park")
public class LivePark {
    @TableId(type = IdType.AUTO)
    private Long liveParkId;
    //业主id
    private Long userId;
    //车位id
    private Long parkId;
    //使用状态
    private Long liveStatue;


}
