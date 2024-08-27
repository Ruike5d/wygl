package com.ityls.web.live_house.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("live_house")
public class LiveHouse {
    //主键
    @TableId(type = IdType.AUTO)
    private Long liveHouseId;
    //用户ID
    private Long userId;
    //房屋ID
    private Long houseId;
    //使用状态默认是0,点了退房就变成1
    private Long useStatus;

}
